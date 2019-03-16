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

import java.util.ArrayList;
import java.util.List;

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
    ReplyMapper replyMapper;
    @Autowired
    FileMapper fileMapper;
    @Autowired
    UserService userService;

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TeacherMapper teacherMapper;

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
    @Ignore
    public void test2() {
//        ReplyExample replyExample = new ReplyExample();
//        List<Reply> list = replyMapper.selectByExample(replyExample);
//        System.out.println(list);

        Reply reply = new Reply(1, null, null, null, (byte) 86, null, null, null);
        System.out.println(replyMapper.updateByPrimaryKeySelective(reply));
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
        System.out.println(userMapper.selectByExampleWithFile(null));
    }

    @Test
    public void test6() {
        List<Student> list = studentMapper.selectByExampleWithGroup(null);
        for (Student student : list) {
            Student judge = studentMapper.selectByExampleWithJudge(student.getSid());
            student.setJudge(judge);
//            System.out.println("班级:" + student.getSclass());
//            System.out.println("学生学号:" + student.getSid());
//            System.out.println("学生姓名:" + student.getSname());
//            System.out.println("教师工号:" + student.getTeacher().getTid());
//            System.out.println("教师姓名:" + student.getTeacher().getTname());
//            System.out.println("课题名称:" + student.getCourse().getCname());
//            System.out.println("评阅教师工号:"+student.getJudge().getTeacher().getTid());
//            System.out.println("评阅教师姓名:"+student.getJudge().getTeacher().getTname());
//            System.out.println("组号:" + student.getSgroup());
        }
        for (Student student : list) {
            System.out.println("班级:" + student.getSclass());
            System.out.println("学生学号:" + student.getSid());
            System.out.println("学生姓名:" + student.getSname());
            System.out.println("教师工号:" + student.getTeacher().getTid());
            System.out.println("教师姓名:" + student.getTeacher().getTname());
            System.out.println("课题名称:" + student.getCourse().getCname());
            System.out.println("评阅教师工号:" + student.getJudge().getTeacher().getTid());
            System.out.println("评阅教师姓名:" + student.getJudge().getTeacher().getTname());
            System.out.println("组号:" + student.getSgroup());
        }
    }

    @Test
    public void test7() {
        System.out.println(studentMapper.selectByExample(null));
    }

    @Test
    public void test8() {
//        StudentExample studentExample = new StudentExample();
//        StudentExample.Criteria criteria = studentExample.createCriteria();
//        criteria.andSidEqualTo("152040135120");
//        Student student = new Student(0, "0");
//        System.out.println(studentMapper.updateByExampleSelective(student, studentExample));
        Student student = studentMapper.selectByPrimaryKey("152040135120");
        System.out.println(student.getTid());
    }
}
