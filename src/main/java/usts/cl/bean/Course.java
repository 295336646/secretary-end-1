package usts.cl.bean;

import lombok.Data;

@Data
public class Course implements Cloneable {
    private Integer cno;

    private String cname;

    private String ctype;

    @Override
    public Object clone() {
        Course course = null;
        try {
            //浅克隆
            course = (Course) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return course;
    }
}