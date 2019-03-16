package usts.cl.bean;

public class Student {
    private String sid;

    private String sname;

    private String sclass;

    private Integer sgroup;

    private Integer cno;

    private String tid;

    private String tjudge;

    private Student judge; // 存放该学生的评阅教师信息

    private Teacher teacher;

    private Course course;

    public Student() {
    }

    public Student(Integer sgroup, String tjudge) {
        this.sgroup = sgroup;
        this.tjudge = tjudge;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass == null ? null : sclass.trim();
    }

    public Integer getSgroup() {
        return sgroup;
    }

    public void setSgroup(Integer sgroup) {
        this.sgroup = sgroup;
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getTjudge() {
        return tjudge;
    }

    public void setTjudge(String tjudge) {
        this.tjudge = tjudge == null ? null : tjudge.trim();
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getJudge() {
        return judge;
    }

    public void setJudge(Student judge) {
        this.judge = judge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", sclass='" + sclass + '\'' +
                ", sgroup=" + sgroup +
                ", cno=" + cno +
                ", tid='" + tid + '\'' +
                ", tjudge='" + tjudge + '\'' +
                ", judge=" + judge +
                ", teacher=" + teacher +
                ", course=" + course +
                '}';
    }
}