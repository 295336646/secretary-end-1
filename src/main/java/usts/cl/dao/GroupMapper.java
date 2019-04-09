package usts.cl.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import usts.cl.bean.Group;
import usts.cl.bean.GroupExample;

public interface GroupMapper {
    long countByExample(GroupExample example);

    int deleteByExample(GroupExample example);

    int insert(Group record);

    int insertSelective(Group record);

    List<Group> selectByExample(GroupExample example);

    int updateByExampleSelective(@Param("record") Group record, @Param("example") GroupExample example);

    int updateByExample(@Param("record") Group record, @Param("example") GroupExample example);
}