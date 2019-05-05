package usts.cl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import usts.cl.bean.Teacher;
import usts.cl.bean.TeacherExample;

public interface TeacherMapper {
    List<Integer> groupSize();

    long countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int deleteByPrimaryKey(String tid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByTeacherWithGroup(int group);

    List<Teacher> selectByExample(TeacherExample example);

    Teacher selectByPrimaryKey(String tid);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}