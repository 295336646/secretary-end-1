package usts.cl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import usts.cl.bean.Group;
import usts.cl.bean.Msg;
import usts.cl.service.GroupService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cl")
public class GroupController {
    @Autowired
    GroupService groupService;

    //获取当前组（模糊查询）
    @GetMapping("/groupAll")
    @ResponseBody
    public Msg groupAll(String tid, String tjudge, String tjudgeName) {
        return Msg.success().add("currentGroup", groupService.getGroup(tid, tjudge, tjudgeName));
    }

    @GetMapping("/showGroup")
    @ResponseBody
    public List<Group> showGroup(int groupNum) {
        return groupService.showGroup(groupNum);
    }

    @PutMapping("/dividedGroup/{groupNum}/{currentLeader}/{leader}/{currentSecretary}/{secretary}")
    @ResponseBody
    public boolean dividedGroup(@PathVariable int groupNum, @RequestBody Map map,
                                @PathVariable String currentLeader, @PathVariable String leader,
                                @PathVariable String currentSecretary, @PathVariable String secretary
    ) {
        return groupService.dividedGroup(groupNum, currentLeader, leader, currentSecretary, secretary, map);
    }
}
