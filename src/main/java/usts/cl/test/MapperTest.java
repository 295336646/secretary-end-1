package usts.cl.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import usts.cl.bean.*;
import usts.cl.dao.*;
import usts.cl.service.UserService;
import usts.cl.utils.PasswordHash;

import java.util.*;

/**
 * 测试dao层的工作
 * 1、导入SpringTest模块
 * 2、@ContextConfiguration指定Spring配置文件的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    UserMapper userMapper;
    @Autowired
    FileMapper fileMapper;
    @Autowired
    UserService userService;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    GradeMapper gradeMapper;

    @Test
    @Ignore
    public void test() throws Exception {
        User user = userMapper.selectByPrimaryKey("152040135121");
        if (user != null) {
            System.out.println("用户已注册");
        } else {
            String[] params = PasswordHash.createHash("123").split(":");
            String hash = params[PasswordHash.PBKDF2_INDEX];
            String salt = params[PasswordHash.SALT_INDEX];
            userMapper.insert(new User("152040135121", "大饼", hash, salt, 2));
        }
//        UserExample userExample = new UserExample();
//        Criteria criteria = userExample.createCriteria();
//        criteria.andUidEqualTo("152040135120");
//        List<User> list = userMapper.selectByExample(userExample);
//        long count = userMapper.countByExample(userExample);
//        System.out.println(count);
//        if (count == 1) {
//            for (User user : list
//                    ) {
//                String hash = user.getPassword();
//                String salt = user.getSalt();
//                System.out.println(user.getUsername());
//                System.out.println(PasswordHash.validatePassword("123", hash, salt));
//            }
//        }
    }

    @Test
    public void test2() {
        List<Student> list = studentMapper.selectByStudentWithGrade(null);
        for (Student student : list) {
            System.out.println("课题名称:" + student.getCourse().getCname());
            System.out.println("学生:" + student.getSname());
            System.out.println("课题类型:" + student.getCourse().getCtype());
            System.out.println("指导评分:" + student.getGrade().getAdvisorGrade());
            System.out.println("评阅评分:" + student.getGrade().getReviewGrade());
            System.out.println("答辩评分:" + student.getGrade().getReplyGrade());
            System.out.println("总成绩:" + student.getGrade().getTotalGrade());
            System.out.println("总评:" + student.getGrade().getGeneralComments());
        }
    }

    @Test
    @Ignore
    public void test3() {
//        List<File> list = fileMapper.selectByExampleWithUser(null);
//        System.out.println(list);
    }

    @Test
    @Ignore
    public void test4() {
        String strs = "321d.doc".substring("321d.doc".lastIndexOf("."));
        System.out.println(strs);
//        for (String str :
//                strs) {
//            System.out.println(str);
//        }
    }

    @Test
    public void test5() {
        Grade grade = new Grade();
        grade.setReplyGrade((byte) 72);
        grade.setTotalGrade((byte) 72);
        System.out.println(gradeMapper.updateBySidSelective(grade, "1220126125"));
    }

    @Test
    public void test6() {
        List<Teacher> teacherList = teacherMapper.selectByExample(null);
        List<Student> studentList = studentMapper.selectByExample(null);
        List<Team> teams = new ArrayList<>();
        int si = studentList.size();
        int tj = teacherList.size();
        int avg = si / tj;
        int sb = 0, tb = 0;
        int k = 0;
        while (sb != studentList.size() && tb != teacherList.size()) {
            for (; avg > 0; avg--) {
                teacherList.get(tb).getStudents().add(studentList.get(sb));
                ++sb;
                --si;
            }
//            Team team = new Team();
//            if (tb % 3 == 0) {
//                k++;
//                List<Teacher> teachers = new ArrayList<>();
//                teachers.add(teacherList.get(tb));
//                teachers.add(teacherList.get(tb + 1));
//                teachers.add(teacherList.get(tb + 2));
//                team.setTeachers(teachers);
//                team.setNumber(k);
//                teacherList.get(tb).setTeam(team);
//                teams.add(team);
//            } else {
//                team.setNumber(k);
//                teacherList.get(tb).setTeam(team);
//            }
//            for (Student student : teacherList.get(tb).getStudents()) {
//                student.setTeam(team);
//            }
            --tj;
            ++tb;
            if (0 == si || 0 == tj) break;
            avg = si / tj;
        }
//        for (Teacher t : teacherList) {
//            teams.get(t.getTeam().getNumber() - 1).getStudents().addAll(t.getStudents());
//        }
//        List<Student> temp = new ArrayList<>();
//        temp.addAll(teacherList1.get(0).getStudents());
//        temp.addAll(teacherList1.get(1).getStudents());
//        temp.addAll(teacherList1.get(2).getStudents());
//        Map<String, Student> map = new HashMap<>();
//        for (Student s : teams.get(0).getStudents()) {
//            map.put(s.getSid(), s);
//        }
//        for (Student s : temp) {
//            if (map.containsKey(s.getSid())) {
//                teams.get(0).getStudents().remove(map.get(s.getSid()));
//                teams.get(0).getExchangeStudents().add(map.get(s.getSid()));
//            }
//        }
//
//        for (Student student : teams.get(0).getStudents()) {
//            System.out.println(student.getSname());
//        }
//        for (Student exchange: teams.get(0).getExchangeStudents()) {
//            System.out.println(exchange.getSname());
//        }
//        System.out.println(teams.get(1).getStudents());
//        System.out.println(teacherList.get(1).getStudents().size());

    }

    @Test
    public void test7() {

        List<Team> teams = new ArrayList<>();// 答辩分组
        this.group(teams);
        List<Integer> list = new ArrayList<>();
        for (Team team : teams) {
            if (team.getExchangeStudents().isEmpty()) list.add(team.getNumber());
        }
        int count = 0;
        while (!list.isEmpty()) {
            count++;
            teams.clear();
            list.clear();
            this.group(teams);
            for (Team team : teams) {
                if (team.getExchangeStudents().isEmpty()) list.add(team.getNumber());
            }
        }
        System.out.println(count);
        for (Team team : teams) {
            for (Student student : team.getStudents()) {
                System.out.print(student.getSname() + ",");
            }
            System.out.println();
        }

//        int group = 0;
//        for (; group < teams.size() - 1; group++) {
//            if ((group + 1) == teams.size() - 1 && teams.get(group + 1).getExchangeStudents().isEmpty()) break;
//            if (teams.get(group + 1).getExchangeStudents().isEmpty()) {
//                List<Student> students = teams.get(group).getExchangeStudents();
//                teams.get(group).setExchangeStudents(teams.get(group + 2).getExchangeStudents());
//                teams.get(group + 2).setExchangeStudents(students);
//                group = group + 2;
//            } else {
//                List<Student> students = teams.get(group + 1).getExchangeStudents();
//                teams.get(group + 1).setExchangeStudents(teams.get(group).getExchangeStudents());
//                teams.get(group).setExchangeStudents(students);
//            }
//        }
//
//        System.out.println("-------------------------------------------");
//        for (Team team : teams) {
//            for (Student student : team.getExchangeStudents()) {
//                System.out.print(student.getSname() + ",");
//            }
//            System.out.println();
//        }
//        System.out.println(teams.get(1).getExchangeStudents().isEmpty());
    }

    public void group(List<Team> teams) {
        long groupSize = teacherMapper.groupSize();// 分组总数
        List<Student> studentList = studentMapper.selectByExample(null);// 所有学生
        List<Teacher> teacherList = teacherMapper.selectByExample(null);//所有老师
        Collections.shuffle(studentList);
        //将分配好的老师录入答辩分组
        for (int i = 1; i <= groupSize; i++) {
            Team team = new Team();
            team.setTeachers(teacherMapper.selectByTeacherWithGroup(i));
            team.setNumber(i);
            teams.add(team);
        }
        int scount = studentList.size(); // 学生总数
        int tcount = teacherList.size();//老师总数
        int sbegin = 0;
        int avg = scount / tcount;//每个老师平均分配多少学生
        int k = 0, count = 0;
//        Set
        // 学生平均分组
        for (Student student : studentList) {
            while (avg > 0) {
                //学生答辩组
                teams.get(k).getStudents().add(studentList.get(sbegin));
                ++sbegin;
                --scount;
                avg--;
            }

            if ((count + 1) % 3 == 0) {
                k++;
            }
            ++count;// 记录每隔3次换组
            --tcount;
            if (0 == scount || 0 == tcount) break;
            avg = scount / tcount;
        }
        Map<String, Student> map = new HashMap<>();
        for (Team team : teams) {
            map.clear();
            for (Student student : team.getStudents()) {
                map.put(student.getSid(), student);
            }
            for (Teacher teacher : team.getTeachers()) {
                for (Student student : teacher.getStudents()) {
                    if (map.containsKey(student.getSid())) {
                        team.getStudents().remove(map.get(student.getSid()));
                        team.getExchangeStudents().add(map.get(student.getSid()));
                    }
                }
            }
        }
    }
}
