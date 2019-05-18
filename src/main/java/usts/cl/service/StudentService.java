package usts.cl.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.cl.bean.Course;
import usts.cl.bean.Msg;
import usts.cl.bean.Student;
import usts.cl.bean.StudentExample;
import usts.cl.dao.CourseMapper;
import usts.cl.dao.StudentMapper;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CourseMapper courseMapper;

    public List<Student> getGradeByLike(String sid, String sname, String generalComments) {
        List<Student> students = studentMapper.selectByLikeWithGrade(sid, sname, generalComments);
        return students;
    }

    public Msg isSelected(String sid) {
        if (!StringUtils.isBlank(studentMapper.selectByPrimaryKey(sid).getCno())) {
            StudentExample studentExample = new StudentExample();
            StudentExample.Criteria criteria = studentExample.createCriteria();
            criteria.andSidEqualTo(sid);
            Student student = studentMapper.selectByStudentWithGroup(studentExample).get(0);
            return Msg.success().add("selected", true).add("student", student);
        }
        return Msg.success().add("selected", false);
    }

}
