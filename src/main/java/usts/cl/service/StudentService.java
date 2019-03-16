package usts.cl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.cl.bean.Student;
import usts.cl.bean.StudentExample;
import usts.cl.bean.StudentExample.Criteria;
import usts.cl.dao.StudentMapper;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public List<Student> getDividedGroup() {
        List<Student> list = studentMapper.selectByExampleWithGroup(null);
        for (Student student : list) {
            Student judge = studentMapper.selectByExampleWithJudge(student.getSid());
            student.setJudge(judge);
        }
        return list;
    }

    public List<Student> getAllStudent() {
        return studentMapper.selectByExample(null);
    }

    public Student getStudent(String sid) {
        return studentMapper.selectByPrimaryKey(sid);
    }

    public Boolean dividedGroup(String sid, Integer sgroup, String tjudge) {
        StudentExample studentExample = new StudentExample();
        Criteria criteria = studentExample.createCriteria();
        criteria.andSidEqualTo(sid);
        Student student = new Student(sgroup, tjudge);
        studentMapper.updateByExampleSelective(student, studentExample);
        return true;
    }
}
