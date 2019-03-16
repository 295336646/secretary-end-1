package usts.cl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.cl.bean.Msg;
import usts.cl.bean.Reply;
import usts.cl.bean.ReplyExample;
import usts.cl.dao.ReplyMapper;

import java.util.List;

@Service
public class ReplyService {
    @Autowired
    ReplyMapper replyMapper;

    public Msg getAllReply() {
        ReplyExample replyExample = new ReplyExample();
        List<Reply> list = replyMapper.selectByExample(replyExample);
        return Msg.success().add("secretaries", list);
    }
    public boolean updateReply(Reply reply){
        replyMapper.updateByPrimaryKeySelective(reply);
        return true;
    }
}
