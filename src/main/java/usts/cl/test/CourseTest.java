package usts.cl.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import usts.cl.dao.*;

/**
 * 测试dao层的工作
 * 1、导入SpringTest模块
 * 2、@ContextConfiguration指定Spring配置文件的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class CourseTest {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    StudentMapper studentMapper;
}
