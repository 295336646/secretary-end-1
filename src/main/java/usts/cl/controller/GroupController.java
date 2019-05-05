package usts.cl.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import usts.cl.bean.Group;
import usts.cl.bean.Msg;
import usts.cl.bean.Teacher;
import usts.cl.service.GroupService;
import usts.cl.service.TeacherService;

import java.util.List;

@Controller
@RequestMapping("/cl")
public class GroupController {
    @Autowired
    GroupService groupService;
    @Autowired
    TeacherService teacherService;

    @GetMapping("/showGroup")
    @ResponseBody
    public List<Group> showGroup(int groupNum) {
        List<Group> result = groupService.showGroup(groupNum);
        return result;
    }

    @GetMapping("/groupAll")
    @ResponseBody
    public Msg groupAll(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 5);
        List<Group> groups = groupService.groupAll();
        PageInfo page = new PageInfo(groups, 5);
        page.setList(groups);
        return Msg.success().add("pageInfo", page);
    }

    @PutMapping("/dividedGroup")
    @ResponseBody
    public boolean dividedGroup() {
        List<Teacher> teachers = teacherService.getAllTeacher();
        for (Teacher teacher : teachers) {
            if (teacher.getTgroup() == 0) {
                return false;
            }
        }
        return groupService.dividedGroup();
    }
}
