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
import java.util.Map;

@Controller
@RequestMapping("/cl")
public class GroupController {
    @Autowired
    GroupService groupService;

    @GetMapping("/groupAll")
    @ResponseBody
    public Msg groupAll(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        return Msg.success().add("pageInfo", groupService.getGroup(pn));
    }

    @GetMapping("/showGroup")
    @ResponseBody
    public List<Group> showGroup(int groupNum) {
        return groupService.showGroup(groupNum);
    }

    @PutMapping("/dividedGroup/{groupNum}/{currentLeader}/{leader}")
    @ResponseBody
    public boolean dividedGroup(@PathVariable int groupNum, @PathVariable String currentLeader,
                                @PathVariable String leader, @RequestBody Map map) {
        return groupService.dividedGroup(groupNum, currentLeader, leader, map);
    }
}
