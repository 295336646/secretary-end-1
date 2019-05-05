package usts.cl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import usts.cl.bean.*;
import usts.cl.dao.GroupMapper;
import usts.cl.dao.StudentMapper;
import usts.cl.dao.TeacherMapper;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTestGroup {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    GroupMapper groupMapper;

    @Test
    public void test1() {
        System.out.println(studentMapper.selectByStudentWithGroup(null));
    }

    @Test
    public void test() {
        Teacher teacherTemp = new Teacher();
        teacherTemp.setTid("30008");
        teacherTemp.setTgroup(3);
        teacherMapper.updateByPrimaryKeySelective(teacherTemp);
        List<Team> teams = new ArrayList<>();// 答辩分组
        this.group(teams);
        rotate(teams, -1);
        List<Group> groups = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        for (Team team : teams) {
            for (Teacher teacher : team.getTeachers()) {
                for (Student student : teacher.getStudents()) {
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
                }
            }
        }
        groupMapper.updateBatch(groups);
        studentMapper.updateBatch(students);
    }

    /**
     * @param teams
     * @param step  为正时，数组左移step，为负时，数组右移step
     */
    public void rotate(List<Team> teams, int step) {
        Team temp = (Team) teams.get(0).clone();//深度复制组
        int last = mod(step * (teams.size() - 1), teams.size());
        for (int j = 0; j != step * teams.size(); j += step) {
            int current = mod(j, teams.size());
            int next = mod(j + step, teams.size());
            if (current == last) {
                transfer(teams.get(current), temp);
//                teams.set(current, temp);
            } else {
//                teams.set(current, teams.get(next));
                transfer(teams.get(current), teams.get(next));
            }
        }
    }

    /**
     * 清空当前组老师下的所有学生
     *
     * @param teachers
     */
    public void clear(List<Teacher> teachers) {
        for (Teacher teacher1 : teachers) {
            teacher1.getStudents().clear();
        }
    }

    /**
     * @param team 当前组
     * @param temp 需要填充的数据
     */
    public void transfer(Team team, Team temp) {
        clear(team.getTeachers());
        Map<Integer, Integer> map = new HashMap<>();
        for (Teacher teacher : temp.getTeachers()) {
            int avg = temp.getStudents().size() / team.getTeachers().size();
            for (Student student : teacher.getStudents()) {
                int i = 0;
                while (true) {
                    int currentIndex = mod(i, team.getTeachers().size());
                    String researchDirection = team.getTeachers().get(currentIndex).getResearchDirection();
                    String ctype = student.getCourse().getCtype();
                    if (team.getTeachers().get(currentIndex).getStudents().size() >= avg) {
                        ++i;
                        if (mod(i, team.getTeachers().size()) == 0) {
                            if (map.isEmpty()) team.getTeachers().get(currentIndex).getStudents().add(student);
                            else team.getTeachers().get(getMinValue(map)).getStudents().add(student);
                            break;
                        }
                        continue;
                    }
                    int priority = allocation(researchDirection, ctype);
                    map.put(currentIndex, priority);
                    ++i;
                    if (mod(i, team.getTeachers().size()) == 0) {
                        if (!map.isEmpty()) team.getTeachers().get(getMinValue(map)).getStudents().add(student);
                        break;
                    }
                }
                map.clear();
            }
        }

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
        for (Team team : teams) {
            for (Teacher teacher : team.getTeachers()) {
                team.getStudents().addAll(teacher.getStudents());
            }
        }
    }
}
