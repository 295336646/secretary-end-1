package usts.cl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import usts.cl.bean.Student;
import usts.cl.bean.StudentExample;

public interface StudentMapper {
    long countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(String sid);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByStudentWithGroup(StudentExample example);

    List<Student> selectByStudentWithGrade(StudentExample example);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(String sid);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}