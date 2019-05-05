package usts.cl.bean;


import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Cloneable,Serializable {
    private String sid;

    private String sname;

    private String sclass;

    private Integer sgroup;

    private Integer cno;

    private String tid;

    private String tjudge;

    private Integer gid;

    private Course course;

    private Grade grade;

    private Teacher teacher;


    @Override
    public Object clone() {
        Student student = null;
        try {
            //浅克隆
            student = (Student) super.clone();
            //深克隆
            student.course = (Course) this.getCourse().clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return student;
    }
}