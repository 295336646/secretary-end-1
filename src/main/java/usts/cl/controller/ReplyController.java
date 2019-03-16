package usts.cl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import usts.cl.bean.Msg;
import usts.cl.bean.Reply;
import usts.cl.service.ReplyService;

@Controller
@RequestMapping("/cl")
public class ReplyController {
    @Autowired
    ReplyService replyService;

    /**
     * 显示所有答辩信息
     *
     * @return
     */
    @ResponseBody
    @GetMapping("/reply")
    public Msg getAllReply() {
        return replyService.getAllReply();
    }

    /**
     * 通过id修改答辩信息
     *
     * @param id
     * @param reply
     * @return
     */
    @ResponseBody
    @PutMapping(value = "/updateReply/{id}")
    public boolean updateReply(@PathVariable("id") Integer id, @RequestBody Reply reply) {
        reply.setId(id);
        return replyService.updateReply(reply);
    }
}
