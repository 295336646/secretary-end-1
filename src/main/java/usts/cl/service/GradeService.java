package usts.cl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usts.cl.bean.Grade;
import usts.cl.dao.GradeMapper;

@Service
public class GradeService {
    @Autowired
    GradeMapper gradeMapper;

    public boolean updateGrade(Grade grade, String sid) {
        gradeMapper.updateBySidSelective(grade, sid);
        return true;
    }

    public Grade selectGrade(String sid) {
        return gradeMapper.selectBySid(sid);
    }
}
