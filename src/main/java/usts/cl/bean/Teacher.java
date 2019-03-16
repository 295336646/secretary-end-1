package usts.cl.bean;

public class Teacher {
    private String tid;

    private String tname;

    private Integer tgroup;

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

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", tgroup=" + tgroup +
                '}';
    }
}