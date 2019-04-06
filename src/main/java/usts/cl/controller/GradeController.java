package usts.cl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import usts.cl.bean.Grade;
import usts.cl.service.GradeService;

@Controller
@RequestMapping("/cl")
public class GradeController {
    @Autowired
    GradeService gradeService;

    @PutMapping("/updateGrade/{sid}")
    @ResponseBody
    public boolean updateGrade(@RequestBody Grade grade, @PathVariable("sid") String sid) {
        gradeService.updateGrade(grade, sid);
        return true;
    }

    @GetMapping("/getGrade")
    @ResponseBody
    public Grade selectGrade(String sid) {
        return gradeService.selectGrade(sid);
    }
}
