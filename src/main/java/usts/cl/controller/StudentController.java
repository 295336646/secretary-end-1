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

    @GetMapping("/likeGrade")
    @ResponseBody
    public Msg likeGrade(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                         @RequestParam(required = false) String sid,
                         @RequestParam(required = false) String sname,
                         @RequestParam(required = false) String generalComments) {
        PageHelper.startPage(pn, 5);
        List<Student> students = studentService.getGradeByLike(sid, sname, generalComments);
        PageInfo page = new PageInfo(students, 5);
        return Msg.success().add("pageInfo", page);
    }
    @GetMapping("/isSelected")
    @ResponseBody
    public Msg isSelected(String sid) {
        return studentService.isSelected(sid);
    }
}
