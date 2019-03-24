package usts.cl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.cl.bean.Student;
import usts.cl.dao.StudentMapper;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public List<Student> ReplyGrade() {
        return studentMapper.selectByStudentWithGrade(null);
    }
}
