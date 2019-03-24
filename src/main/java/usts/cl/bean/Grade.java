package usts.cl.bean;

public class Grade {
    private Integer id;

    private Byte advisorGrade;

    private Byte reviewGrade;

    private Byte replyGrade;

    private Byte totalGrade;

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

    public String getGeneralComments() {
        return generalComments;
    }

    public void setGeneralComments(String generalComments) {
        this.generalComments = generalComments == null ? null : generalComments.trim();
    }
}