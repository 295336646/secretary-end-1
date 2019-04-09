package usts.cl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import usts.cl.bean.Group;
import usts.cl.service.GroupService;

import java.util.List;

@Controller
@RequestMapping("/cl")
public class GroupController {
    @Autowired
    GroupService groupService;

    @GetMapping("/showGroup")
    @ResponseBody
    public List<Group> showGroup(String tjudge) {
        return groupService.showGroup(tjudge);
    }

    @PutMapping("/dividedGroup/{tid}")
    @ResponseBody
    public boolean dividedGroup(@PathVariable("tid") String tid, int groupNum) {
        return groupService.dividedGroup(tid, groupNum);
    }
}
