package usts.cl.bean;


public class Student implements Cloneable {
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

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

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
                ", gid=" + gid +
                ", course=" + course +
                ", grade=" + grade +
                ", teacher=" + teacher +
                '}';
    }
}