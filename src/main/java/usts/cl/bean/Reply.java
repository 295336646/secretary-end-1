package usts.cl.bean;

public class Reply {
    private Integer id;

    private String subjectName;

    private String student;

    private String subjectType;

    private Byte guidanceScore;

    private Byte ratingScore;

    private Byte replyScore;

    private String state;

    public Reply() {
    }

    public Reply(Integer id, String subjectName, String student, String subjectType, Byte guidanceScore, Byte ratingScore, Byte replyScore, String state) {
        this.id = id;
        this.subjectName = subjectName;
        this.student = student;
        this.subjectType = subjectType;
        this.guidanceScore = guidanceScore;
        this.ratingScore = ratingScore;
        this.replyScore = replyScore;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student == null ? null : student.trim();
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType == null ? null : subjectType.trim();
    }

    public Byte getGuidanceScore() {
        return guidanceScore;
    }

    public void setGuidanceScore(Byte guidanceScore) {
        this.guidanceScore = guidanceScore;
    }

    public Byte getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(Byte ratingScore) {
        this.ratingScore = ratingScore;
    }

    public Byte getReplyScore() {
        return replyScore;
    }

    public void setReplyScore(Byte replyScore) {
        this.replyScore = replyScore;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                ", student='" + student + '\'' +
                ", subjectType='" + subjectType + '\'' +
                ", guidanceScore=" + guidanceScore +
                ", ratingScore=" + ratingScore +
                ", replyScore=" + replyScore +
                ", state='" + state + '\'' +
                '}';
    }
}