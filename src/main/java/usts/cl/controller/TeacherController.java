package usts.cl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import usts.cl.bean.Teacher;
import usts.cl.service.TeacherService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cl")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    /**
     * 显示所有教师
     *
     * @return
     */
    @GetMapping("/showTeachers")
    @ResponseBody
    public List<Teacher> getAllTeacher() {
        return teacherService.getAllTeacher();
    }

    @PostMapping("/dividedTeacher/{groupNum}/{currentLeader}/{leader}")
    @ResponseBody
    public Boolean dividedTeacher(@PathVariable int groupNum, @PathVariable String currentLeader,
                                  @PathVariable String leader, @RequestBody Map map) {
        return teacherService.dividedTeacher(groupNum, currentLeader, leader, map);
    }

    @GetMapping("/getGroupTeacher")
    @ResponseBody
    public List<Teacher> getGroupTeacher(int groupNum) {
        return teacherService.getGroupTeacher(groupNum);
    }
}
