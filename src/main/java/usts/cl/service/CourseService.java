package usts.cl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.cl.bean.Course;
import usts.cl.bean.CourseExample;
import usts.cl.dao.CourseMapper;
import usts.cl.dao.TeacherMapper;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    TeacherMapper teacherMapper;

    //申报课题
    public Boolean applyCourse(Course course) {
        courseMapper.insertSelective(course);
        return true;
    }

    //查看当前教师提交课题状态
    public List<Course> getCourse(String tid) {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andTidEqualTo(tid);
        return courseMapper.selectByExample(courseExample);
    }

    public Boolean updateCourse(Course course) {
        courseMapper.updateByPrimaryKey(course);
        return true;
    }

    //查看课题
    public List<Course> courseAll(Byte state) {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andStateEqualTo(state);
        return courseMapper.selectByCourseWithTeacher(courseExample);
    }
    public Boolean selectCourse(Course course, String sno) {
        course.setState((byte) 3);
        courseMapper.updateByPrimaryKeySelective(course);
        return true;
    }
}
