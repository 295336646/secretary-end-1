package usts.cl.bean;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private String tid;

    private String tname;

    private Integer tgroup;

    private List<Student> students = new ArrayList<>();

    private Team team = new Team();

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", tgroup=" + tgroup +
                ", students=" + students +
                ", team=" + team +
                '}';
    }
}