package usts.cl.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import usts.cl.bean.Group;
import usts.cl.bean.GroupExample;
import usts.cl.bean.Teacher;
import usts.cl.bean.Team;

public interface GroupMapper {
    long countByExample(GroupExample example);

    int deleteByExample(GroupExample example);

    int insert(Group record);

    int insertSelective(Group record);

    List<Group> selectByLeader();

    List<Group> selectByGroup(GroupExample example);

    List<Group> selectByExample(GroupExample example);

    int updateBatch(@Param("groups") List<Group> groups);

    int updateByExampleSelective(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByExample(@Param("record") Group record, @Param("example") GroupExample example);
}