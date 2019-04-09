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
        List<Team> teams = new ArrayList<>();// 答辩分组

        this.group(teams);
        for (Team team : teams) {
            for (Teacher teacher : team.getTeachers()) {
                for (Student student : teacher.getStudents()) {
                    GroupExample groupExample = new GroupExample();
                    GroupExample.Criteria criteria = groupExample.createCriteria();
                    criteria.andSidEqualTo(student.getSid());
                    Group group = new Group();
                    group.setTname(teacher.getTname());
                    groupMapper.updateByExampleSelective(group, groupExample);
                }
            }
        }
//        rotate(teams, -1);
//        for (Team team : teams) {
//            for (Teacher teacher : team.getTeachers()) {
//                for (Student student : teacher.getStudents()) {
//                    student.setSgroup(team.getNumber());
//                    student.setTjudge(teacher.getTid());
//                    studentMapper.updateByPrimaryKeySelective(student);
//                }
//            }
//        }

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
                transfer(teams.get(current), temp.getTeachers());
//                teams.set(current, temp);
            } else {
//                teams.set(current, teams.get(next));
                transfer(teams.get(current), teams.get(next).getTeachers());
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
     * @param team     当前组
     * @param teachers 需要填充的数据
     */
    public void transfer(Team team, List<Teacher> teachers) {
        clear(team.getTeachers());
        int i = 0;
        List<Student> students = new ArrayList<>();//存储分组失败的学生
        for (Teacher teacher : teachers) {
            for (Student student : teacher.getStudents()) {
                int count = 0;
                boolean flag = false;
                while (!allocation(team.getTeachers().get(mod(i, team.getTeachers().size())).getResearchDirection(), student.getCourse().getCtype())) {
                    ++count;
                    ++i;
                    if (0 == mod(count, team.getTeachers().size())) {
                        students.add(student);
                        flag = true;
                        break;
                    }
                }
                //强制分配
                if (!students.isEmpty()) {
                    team.getTeachers().get(mod(i, team.getTeachers().size())).getStudents().add(student);
                }
                if (!flag) {
                    team.getTeachers().get(mod(i, team.getTeachers().size())).getStudents().add(student);
                }
                students.clear();
                i++;
            }
        }

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
    public boolean allocation(String direction, String cType) {
        if (direction.equals("信息管理")) {
            if (cType.equals("应用设计偏硬")) {
                return false;
            }
        }
        if (direction.equals("嵌入式")) {
            if (cType.equals("应用研究") || cType.equals("算法研究")) {
                return false;
            }
        }
        return true;
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
    }
}
