package usts.cl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import usts.cl.bean.Student;
import usts.cl.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/cl")
public class StudentController {
    @Autowired
    StudentService studentService;

    /**
     * 显示所有分组
     * @return
     */
    @GetMapping("/showGroups")
    @ResponseBody
    public List<Student> getDividedGroup() {
        return studentService.getDividedGroup();
    }

    /**
     * 显示所有学生
     * @return
     */
    @GetMapping("showStudents")
    @ResponseBody
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    /**
     * 通过sid修改分组信息
     * @param sid
     * @param sgroup
     * @param tjudge
     * @return
     */
    @PutMapping("dividedGroup/{sid}")
    @ResponseBody
    public Boolean dividedGroup(@PathVariable("sid") String sid, Integer sgroup, String tjudge) {
        Student student = studentService.getStudent(sid);
        if (student.getTid().equals(tjudge)) {
            return false;
        }else {
            return studentService.dividedGroup(sid, sgroup, tjudge);
        }
    }
}
