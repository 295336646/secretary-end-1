package usts.cl.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Teacher implements Cloneable,Serializable {
    private String tid;

    private String tname;

    private String profession;

    private String researchDirection;

    private Integer tgroup;

    private Byte leader;

    private List<Student> students = new ArrayList<>();

    @Override
    public Object clone() {
        Teacher teacher = null;
        try {
            //浅克隆
            teacher = (Teacher) super.clone();
            //深克隆
            List<Student> listBeans = new ArrayList<>();
            for (Student itemList :
                    students) {
                listBeans.add((Student) itemList.clone());
            }
            students = listBeans;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return teacher;
    }
}