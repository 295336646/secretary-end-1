package usts.cl.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.cl.bean.Grade;
import usts.cl.bean.Group;
import usts.cl.dao.GradeMapper;

@Service
public class GradeService {
    @Autowired
    GradeMapper gradeMapper;

//    @Autowired
//    RedisService redisService;

    public synchronized boolean updateGrade(Grade grade, String sid) {
//        redisService.del("grade:" + sid);
        gradeMapper.updateBySidSelective(grade, sid);
        return true;
    }

    public Grade selectGrade(String sid) {
//        if (redisService.existKey("grade:" + sid)) {
//            JSONObject jsonObject = JSONObject.fromObject(redisService.get("grade:" + sid));
//            Grade grade = (Grade) JSONObject.toBean(jsonObject, Grade.class);
//            return grade;
//        } else {
            Grade grade = gradeMapper.selectBySid(sid);
//            redisService.set("grade:" + sid, JSONObject.fromObject(grade).toString());
            return grade;
//        }
    }
}
