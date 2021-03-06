package usts.cl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.cl.bean.*;
import usts.cl.dao.TeacherMapper;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    public List<Teacher> getAllTeacher() {
        return teacherMapper.selectByExample(null);
    }

    public List<Teacher> getGroupTeacher(int groupNum) {
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andTgroupEqualTo(groupNum);
        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
        return teachers;
    }

}
