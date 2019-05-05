package usts.cl.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import usts.cl.bean.Msg;
import usts.cl.bean.Student;
import usts.cl.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("cl")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/reply")
    @ResponseBody
    public Msg ReplyGrade(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 5);
        List<Student> students = studentService.ReplyGrade();
        PageInfo page = new PageInfo(students,5);
        return Msg.success().add("pageInfo", page);
    }
}
