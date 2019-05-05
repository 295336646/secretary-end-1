package usts.cl.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import usts.cl.bean.Teacher;
import usts.cl.bean.TeacherExample;
import usts.cl.dao.TeacherMapper;

import java.util.List;
import java.util.Map;

@Service
public class TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    public List<Teacher> getAllTeacher() {
        return teacherMapper.selectByExample(null);
    }

    public Teacher getTeacher(String leader) {
        return teacherMapper.selectByPrimaryKey(leader);
    }

    public List<Teacher> getGroupTeacher(int groupNum) {
        TeacherExample teacherExample = new TeacherExample();
        teacherExample.createCriteria().andTgroupEqualTo(groupNum);
        List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
        return teachers;
    }

    public Boolean dividedTeacher(int groupNum, String currentLeader, String leader, Map map) {
        Teacher newLeaderTeacher = getTeacher(leader);
        Teacher currentLeaderTeacher = getTeacher(currentLeader);
        if (!currentLeader.equals(leader)) {
            //选的人已经时答辩组长，则分组失败
            if (newLeaderTeacher.getLeader() == 1) {
                return false;
            } else {//换组长
                //当前组的答辩组长下台
                currentLeaderTeacher.setLeader((byte) 0);
                //新答辩组长上台
                newLeaderTeacher.setTgroup(groupNum);
                newLeaderTeacher.setLeader((byte) 1);
            }
        }
        JSONArray allocated = JSONArray.fromObject(map.get("allocated"));
        JSONArray unallocated = JSONArray.fromObject(map.get("unallocated"));
        //分配答辩组
        for (Object jsonObject : allocated) {
            Teacher allocatedTeacher = (Teacher) JSONObject.toBean(
                    (JSONObject) jsonObject, Teacher.class);
            allocatedTeacher.setTgroup(groupNum);
            teacherMapper.updateByPrimaryKeySelective(allocatedTeacher);
        }
        //未被分配的答辩组
        for (Object jsonObject : unallocated) {
            Teacher unallocatedTeacher = (Teacher) JSONObject.toBean(
                    (JSONObject) jsonObject, Teacher.class);
            if (unallocatedTeacher.getLeader() == 1) {
                return false;
            }
        }
        for (Object jsonObject : unallocated) {
            Teacher unallocatedTeacher = (Teacher) JSONObject.toBean(
                    (JSONObject) jsonObject, Teacher.class);
            unallocatedTeacher.setTgroup(0);
            teacherMapper.updateByPrimaryKeySelective(unallocatedTeacher);
        }
        teacherMapper.updateByPrimaryKeySelective(newLeaderTeacher);
        teacherMapper.updateByPrimaryKeySelective(currentLeaderTeacher);
        return true;
    }
}
