package usts.cl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import usts.cl.bean.*;
import usts.cl.dao.GroupMapper;
import usts.cl.dao.StudentMapper;
import usts.cl.dao.TeacherMapper;
import usts.cl.redis.RedisLogService;

import java.util.*;

@Service
public class GroupService {
    @Autowired
    private GroupMapper groupMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    RedisTemplate redisTemplate;

    @RedisLogService(key = "group")
    public List<Group> groupAll() {
        List<Group> groups = groupMapper.selectByGroup(null);
        BoundHashOperations<String, String, Object> boundHashOperations = redisTemplate.boundHashOps("group");
        boundHashOperations.put("groupAll", groups);
        return groups;
    }

    public PageInfo getGroup(Integer pn) {
        PageHelper.startPage(pn, 5);
        List<Group> groups = groupMapper.selectByGroup(null);
        PageInfo page = new PageInfo(groups, 5);
        return page;
    }

    @RedisLogService(key = "group")
    public List<Group> getLeader() {
        List<Group> groups = groupMapper.selectByGroup(null);
        BoundHashOperations<String, String, Object> boundHashOperations = redisTemplate.boundHashOps("group");
        boundHashOperations.put("getLeader", groups);
        return groupMapper.selectByLeader();
    }

    public Boolean dividedTeacher(int groupNum, String currentLeader, String leader, Map map) {
        Teacher newLeaderTeacher = teacherMapper.selectByPrimaryKey(leader);
        Teacher currentLeaderTeacher = teacherMapper.selectByPrimaryKey(currentLeader);
        if (!currentLeader.equals(leader)) {
            //选的人已经时答辩组长，则分组失败
            if (newLeaderTeacher.getLeader() == 1) {
                return false;
            } else {//换组长
                //当前组的答辩组长下台
                currentLeaderTeacher.setLeader((byte) 0);
                //新答辩组长上台
                newLeaderTeacher.setTgroup(groupNum);
                newLeaderTeacher.setLeader((byte) 1);
            }
        }
        JSONArray allocated = JSONArray.fromObject(map.get("allocated"));
        JSONArray unallocated = JSONArray.fromObject(map.get("unallocated"));
        //未被分配的答辩组
        for (Object jsonObject : unallocated) {
            Teacher unallocatedTeacher = (Teacher) JSONObject.toBean(
                    (JSONObject) jsonObject, Teacher.class);
            if (unallocatedTeacher.getLeader() == 1) {
                return false;
            }
        }
        //分配答辩组
        for (Object jsonObject : allocated) {
            Teacher allocatedTeacher = (Teacher) JSONObject.toBean(
                    (JSONObject) jsonObject, Teacher.class);
            allocatedTeacher.setTgroup(groupNum);
            teacherMapper.updateByPrimaryKeySelective(allocatedTeacher);
        }
        for (Object jsonObject : unallocated) {
            Teacher unallocatedTeacher = (Teacher) JSONObject.toBean(
                    (JSONObject) jsonObject, Teacher.class);
            unallocatedTeacher.setTgroup(0);
            teacherMapper.updateByPrimaryKeySelective(unallocatedTeacher);
        }
        teacherMapper.updateByPrimaryKeySelective(newLeaderTeacher);
        teacherMapper.updateByPrimaryKeySelective(currentLeaderTeacher);
        return true;
    }

    @RedisLogService(key = "group", cacheOperation = RedisLogService.CACHE_OPERATION.UPDATE)
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean dividedGroup(int groupNum, String currentLeader, String leader, Map map) {
        boolean flag = dividedTeacher(groupNum, currentLeader, leader, map);
        JSONArray unallocated = JSONArray.fromObject(map.get("unallocated"));
        // 全部老师已经分配完，分配学生
        if (unallocated.size() == 0 && flag) {
            List<Team> teams = new ArrayList<>();// 答辩分组
            this.group(teams);//初始分组
            this.rotate(teams, -1);//轮询分组
            List<Group> groups = new ArrayList<>();
            List<Student> students = new ArrayList<>();
            teams.forEach(team -> team.getTeachers()
                    .forEach(teacher -> teacher.getStudents()
                            .forEach(student -> {
                                Group group = new Group();
                                group.setSid(student.getSid());
                                group.setTjudge(teacher.getTid());
                                group.setTjudgename(teacher.getTname());
                                group.setGroupnum(teacher.getTgroup());
                                group.setLeader(teacher.getLeader());
                                groups.add(group);
                                student.setSgroup(teacher.getTgroup());
                                student.setTjudge(teacher.getTid());
                                students.add(student);
                            })));
            studentMapper.updateBatch(students);
            groupMapper.updateBatch(groups);
        }
        return flag;
    }

    @RedisLogService(key = "group")
    public List<Group> showGroup(int groupNum) {
        GroupExample groupExample = new GroupExample();
        groupExample.setOrderByClause("tjudgeName DESC");
        GroupExample.Criteria criteria = groupExample.createCriteria();
        criteria.andGroupnumEqualTo(groupNum);
        List<Group> groups = groupMapper.selectByExample(groupExample);
        BoundHashOperations<String, String, Object> boundHashOperations = redisTemplate.boundHashOps("group");
        boundHashOperations.put(String.valueOf(groupNum), groups);
        return groups;
    }

    /**
     * @param teams
     * @param step  为正时，数组左移step，为负时，数组右移step
     */
    public void rotate(List<Team> teams, int step) {
        Team temp = (Team) teams.get(0).clone();//深度复制组
        //分组长度为7，step为1，那么计算结果为1，即最后一个交换位置为1
        int last = mod(step * (teams.size() - 1), teams.size());//标记结束位置
        // 顺序1->2->3->4->5->1
        for (int j = 0; j != step * teams.size(); j += step) {
            //current遍历后的顺序依次为0,6,5,4,3,2,1
            int current = mod(j, teams.size());
            //next遍历后的顺序依次为6,5,4,3,2,1,0
            int next = mod(j + step, teams.size());
            //递交顺序：6->0,5->6,4->5,3->4,2->3,1->2,0->1
            if (current == last) {
                this.transfer(teams.get(current), temp);
            } else {
                this.transfer(teams.get(current), teams.get(next));
            }
        }
    }

    /**
     * 清空当前组老师下的所有学生
     *
     * @param teachers
     */
    public void clear(List<Teacher> teachers) {
        for (Teacher teacher : teachers) {
            teacher.getStudents().clear();
        }
    }

    /**
     * @param team 当前组
     * @param temp 需要填充的数据
     *             temp中的学生流向team中的学生
     */
    public void transfer(Team team, Team temp) {
        //清空当前组老师下的所有学生，以便添加新学生
        this.clear(team.getTeachers());
        //待分配的学生数目/待分配的老师数目
        int avg = temp.getStudents().size() / team.getTeachers().size();
        temp.getTeachers().forEach(teacher -> teacher.getStudents()
                .forEach(student -> {
                    //map记录当前老师位置以及对应的优先级
                    Map<Integer, Integer> map = new HashMap<>();
                    int i = 0;//标记循环次数
                    while (true) {
                        int currentIndex = this.mod(i, team.getTeachers().size());
                        if (team.getTeachers().get(currentIndex).getStudents().size() >= avg) {//待分配老师所分配学生数量超过了阈值
                            ++i;
                            if (this.mod(i, team.getTeachers().size()) == 0) {//此时正好当前老师是最后一位老师
                                //往优先级最高的老师分配学生
                                if (!map.isEmpty()) team.getTeachers().get(getMinValue(map)).getStudents().add(student);
                                else
                                    team.getTeachers().get(currentIndex).getStudents().add(student);//前面几位老师都满了，只能分配给最后一组
                                break;
                            }
                            continue;//不是最后一名老师，则跳过当前老师，直接分配下一位老师
                        }
                        String researchDirection = team.getTeachers().get(currentIndex).getResearchDirection();//待分配老师的研究方向
                        String ctype = student.getCourse().getCtype();//待分配学生的课题类型
                        //优先级顺序：1>2>3>4
                        int priority = this.allocation(researchDirection, ctype);
                        //记录该老师的优先级
                        map.put(currentIndex, priority);
                        ++i;
                        if (mod(i, team.getTeachers().size()) == 0) {
                            //往优先级最高的老师分配学生
                            if (!map.isEmpty()) team.getTeachers().get(getMinValue(map)).getStudents().add(student);
                            break;
                        }
                    }
                }));
    }

    /**
     * 求Map<K,V>中Value(值)的最小值
     *
     * @param map
     * @return
     */
    public Integer getMinValue(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (o1, o2) -> (o1.getValue() - o2.getValue()));
        return list.get(0).getKey();
    }

    /**
     * 取模运算，如果取模为负数则转成正数的模
     *
     * @param x
     * @param y
     * @return
     */
    public int mod(int x, int y) {
        return (((x % y) + y) % y);
    }

    /**
     * 按方向分配
     *
     * @param direction 老师研究方向
     * @param cType     课题类型
     * @return
     */
    public int allocation(String direction, String cType) {
        if (cType.equals("应用设计")) {
            if (direction.equals("信息管理")) return 1;
            if (direction.equals("系统")) return 2;
            if (direction.equals("算法")) return 3;
            if (direction.equals("嵌入式")) return 4;
        } else if (cType.equals("应用设计偏硬")) {
            if (direction.equals("嵌入式")) return 1;
            if (direction.equals("系统")) return 2;
            if (direction.equals("算法")) return 3;
            if (direction.equals("信息管理")) return 4;
        } else {
            if (direction.equals("算法")) return 1;
            if (direction.equals("系统")) return 2;
            if (direction.equals("嵌入式")) return 3;
            if (direction.equals("信息管理")) return 4;
        }
        return 0;
    }

    /**
     * 初始分组
     *
     * @param teams
     */
    public void group(List<Team> teams) {
        long groupSize = teacherMapper.groupSize().size();// 分组总数
        //将分配好的老师录入答辩分组
        for (int i = 1; i <= groupSize; i++) {
            Team team = new Team();
            team.setTeachers(teacherMapper.selectByTeacherWithGroup(i));
            team.setNumber(i);
            teams.add(team);
        }
        teams.stream().forEach(team -> team.getTeachers()
                .forEach(teacher -> team.getStudents().addAll(teacher.getStudents())));
    }

}
