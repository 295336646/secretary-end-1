package usts.cl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import usts.cl.bean.Student;
import usts.cl.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("cl")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("reply")
    @ResponseBody
    public List<Student> ReplyGrade() {
        return studentService.ReplyGrade();
    }
}
