package usts.cl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import usts.cl.bean.Course;
import usts.cl.service.CourseService;

import java.util.List;

@Controller
@RequestMapping("/cl")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("applyCourse")
    @ResponseBody
    public Boolean applyCourse(@RequestBody Course course) {
        return courseService.applyCourse(course);
    }

    @PutMapping("updateCourse")
    @ResponseBody
    public Boolean updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    @GetMapping("getCourse")
    @ResponseBody
    public List<Course> getCourse(String tid) {
        return courseService.getCourse(tid);
    }

    @GetMapping("courseAll")
    @ResponseBody
    public List<Course> courseAll(Byte state) {
        return courseService.courseAll(state);
    }

}
