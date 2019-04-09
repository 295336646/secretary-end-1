package usts.cl.bean;

public class Group {
    private String sid;

    private String sclass;

    private String sname;

    private String tid;

    private String tname;

    private String cname;

    private String tjudge;

    private String tjudgename;

    private Integer groupnum;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass == null ? null : sclass.trim();
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getTjudge() {
        return tjudge;
    }

    public void setTjudge(String tjudge) {
        this.tjudge = tjudge == null ? null : tjudge.trim();
    }

    public String getTjudgename() {
        return tjudgename;
    }

    public void setTjudgename(String tjudgename) {
        this.tjudgename = tjudgename == null ? null : tjudgename.trim();
    }

    public Integer getGroupnum() {
        return groupnum;
    }

    public void setGroupnum(Integer groupnum) {
        this.groupnum = groupnum;
    }

    @Override
    public String toString() {
        return "Group{" +
                "sid='" + sid + '\'' +
                ", sclass='" + sclass + '\'' +
                ", sname='" + sname + '\'' +
                ", tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", cname='" + cname + '\'' +
                ", tjudge='" + tjudge + '\'' +
                ", tjudgename='" + tjudgename + '\'' +
                ", groupnum=" + groupnum +
                '}';
    }
}