package usts.cl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import usts.cl.bean.Course;
import usts.cl.bean.CourseExample;

public interface CourseMapper {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Integer cno);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    List<Course> selectByCourseWithTeacher(CourseExample example);

    Course selectByPrimaryKey(Integer cno);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);
}