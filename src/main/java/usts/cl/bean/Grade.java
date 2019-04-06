package usts.cl.bean;

public class Grade {
    private Integer id;

    private Byte advisorGrade;

    private Byte reviewGrade;

    private Byte replyGrade;

    private Byte totalGrade;

    private Byte task;

    private Byte technology;

    private Byte language;

    private Byte answer;

    private String comments;

    private String generalComments;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getAdvisorGrade() {
        return advisorGrade;
    }

    public void setAdvisorGrade(Byte advisorGrade) {
        this.advisorGrade = advisorGrade;
    }

    public Byte getReviewGrade() {
        return reviewGrade;
    }

    public void setReviewGrade(Byte reviewGrade) {
        this.reviewGrade = reviewGrade;
    }

    public Byte getReplyGrade() {
        return replyGrade;
    }

    public void setReplyGrade(Byte replyGrade) {
        this.replyGrade = replyGrade;
    }

    public Byte getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(Byte totalGrade) {
        this.totalGrade = totalGrade;
    }

    public Byte getTask() {
        return task;
    }

    public void setTask(Byte task) {
        this.task = task;
    }

    public Byte getTechnology() {
        return technology;
    }

    public void setTechnology(Byte technology) {
        this.technology = technology;
    }

    public Byte getLanguage() {
        return language;
    }

    public void setLanguage(Byte language) {
        this.language = language;
    }

    public Byte getAnswer() {
        return answer;
    }

    public void setAnswer(Byte answer) {
        this.answer = answer;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public String getGeneralComments() {
        return generalComments;
    }

    public void setGeneralComments(String generalComments) {
        this.generalComments = generalComments == null ? null : generalComments.trim();
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", advisorGrade=" + advisorGrade +
                ", reviewGrade=" + reviewGrade +
                ", replyGrade=" + replyGrade +
                ", totalGrade=" + totalGrade +
                ", task=" + task +
                ", technology=" + technology +
                ", language=" + language +
                ", answer=" + answer +
                ", comments='" + comments + '\'' +
                ", generalComments='" + generalComments + '\'' +
                '}';
    }
}