package usts.cl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import usts.cl.bean.Teacher;
import usts.cl.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/cl")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    /**
     * 显示所有教师
     * @return
     */
    @GetMapping("/showTeachers")
    @ResponseBody
    public List<Teacher> getAllTeacher() {
        return teacherService.getAllTeacher();
    }
}
