package usts.cl.bean;

import java.util.ArrayList;
import java.util.List;

public class Teacher implements Cloneable {
    private String tid;

    private String tname;

    private String profession;

    private String researchDirection;

    private Integer tgroup;

    private List<Student> students = new ArrayList<>();

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getResearchDirection() {
        return researchDirection;
    }

    public void setResearchDirection(String researchDirection) {
        this.researchDirection = researchDirection == null ? null : researchDirection.trim();
    }

    public Integer getTgroup() {
        return tgroup;
    }

    public void setTgroup(Integer tgroup) {
        this.tgroup = tgroup;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


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

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", profession='" + profession + '\'' +
                ", researchDirection='" + researchDirection + '\'' +
                ", tgroup=" + tgroup +
                ", students=" + students +
                '}';
    }
}