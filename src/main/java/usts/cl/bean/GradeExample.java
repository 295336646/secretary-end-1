package usts.cl.bean;

import java.util.ArrayList;
import java.util.List;

public class GradeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GradeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAdvisorGradeIsNull() {
            addCriterion("advisor_grade is null");
            return (Criteria) this;
        }

        public Criteria andAdvisorGradeIsNotNull() {
            addCriterion("advisor_grade is not null");
            return (Criteria) this;
        }

        public Criteria andAdvisorGradeEqualTo(Byte value) {
            addCriterion("advisor_grade =", value, "advisorGrade");
            return (Criteria) this;
        }

        public Criteria andAdvisorGradeNotEqualTo(Byte value) {
            addCriterion("advisor_grade <>", value, "advisorGrade");
            return (Criteria) this;
        }

        public Criteria andAdvisorGradeGreaterThan(Byte value) {
            addCriterion("advisor_grade >", value, "advisorGrade");
            return (Criteria) this;
        }

        public Criteria andAdvisorGradeGreaterThanOrEqualTo(Byte value) {
            addCriterion("advisor_grade >=", value, "advisorGrade");
            return (Criteria) this;
        }

        public Criteria andAdvisorGradeLessThan(Byte value) {
            addCriterion("advisor_grade <", value, "advisorGrade");
            return (Criteria) this;
        }

        public Criteria andAdvisorGradeLessThanOrEqualTo(Byte value) {
            addCriterion("advisor_grade <=", value, "advisorGrade");
            return (Criteria) this;
        }

        public Criteria andAdvisorGradeIn(List<Byte> values) {
            addCriterion("advisor_grade in", values, "advisorGrade");
            return (Criteria) this;
        }

        public Criteria andAdvisorGradeNotIn(List<Byte> values) {
            addCriterion("advisor_grade not in", values, "advisorGrade");
            return (Criteria) this;
        }

        public Criteria andAdvisorGradeBetween(Byte value1, Byte value2) {
            addCriterion("advisor_grade between", value1, value2, "advisorGrade");
            return (Criteria) this;
        }

        public Criteria andAdvisorGradeNotBetween(Byte value1, Byte value2) {
            addCriterion("advisor_grade not between", value1, value2, "advisorGrade");
            return (Criteria) this;
        }

        public Criteria andReviewGradeIsNull() {
            addCriterion("review_grade is null");
            return (Criteria) this;
        }

        public Criteria andReviewGradeIsNotNull() {
            addCriterion("review_grade is not null");
            return (Criteria) this;
        }

        public Criteria andReviewGradeEqualTo(Byte value) {
            addCriterion("review_grade =", value, "reviewGrade");
            return (Criteria) this;
        }

        public Criteria andReviewGradeNotEqualTo(Byte value) {
            addCriterion("review_grade <>", value, "reviewGrade");
            return (Criteria) this;
        }

        public Criteria andReviewGradeGreaterThan(Byte value) {
            addCriterion("review_grade >", value, "reviewGrade");
            return (Criteria) this;
        }

        public Criteria andReviewGradeGreaterThanOrEqualTo(Byte value) {
            addCriterion("review_grade >=", value, "reviewGrade");
            return (Criteria) this;
        }

        public Criteria andReviewGradeLessThan(Byte value) {
            addCriterion("review_grade <", value, "reviewGrade");
            return (Criteria) this;
        }

        public Criteria andReviewGradeLessThanOrEqualTo(Byte value) {
            addCriterion("review_grade <=", value, "reviewGrade");
            return (Criteria) this;
        }

        public Criteria andReviewGradeIn(List<Byte> values) {
            addCriterion("review_grade in", values, "reviewGrade");
            return (Criteria) this;
        }

        public Criteria andReviewGradeNotIn(List<Byte> values) {
            addCriterion("review_grade not in", values, "reviewGrade");
            return (Criteria) this;
        }

        public Criteria andReviewGradeBetween(Byte value1, Byte value2) {
            addCriterion("review_grade between", value1, value2, "reviewGrade");
            return (Criteria) this;
        }

        public Criteria andReviewGradeNotBetween(Byte value1, Byte value2) {
            addCriterion("review_grade not between", value1, value2, "reviewGrade");
            return (Criteria) this;
        }

        public Criteria andReplyGradeIsNull() {
            addCriterion("reply_grade is null");
            return (Criteria) this;
        }

        public Criteria andReplyGradeIsNotNull() {
            addCriterion("reply_grade is not null");
            return (Criteria) this;
        }

        public Criteria andReplyGradeEqualTo(Byte value) {
            addCriterion("reply_grade =", value, "replyGrade");
            return (Criteria) this;
        }

        public Criteria andReplyGradeNotEqualTo(Byte value) {
            addCriterion("reply_grade <>", value, "replyGrade");
            return (Criteria) this;
        }

        public Criteria andReplyGradeGreaterThan(Byte value) {
            addCriterion("reply_grade >", value, "replyGrade");
            return (Criteria) this;
        }

        public Criteria andReplyGradeGreaterThanOrEqualTo(Byte value) {
            addCriterion("reply_grade >=", value, "replyGrade");
            return (Criteria) this;
        }

        public Criteria andReplyGradeLessThan(Byte value) {
            addCriterion("reply_grade <", value, "replyGrade");
            return (Criteria) this;
        }

        public Criteria andReplyGradeLessThanOrEqualTo(Byte value) {
            addCriterion("reply_grade <=", value, "replyGrade");
            return (Criteria) this;
        }

        public Criteria andReplyGradeIn(List<Byte> values) {
            addCriterion("reply_grade in", values, "replyGrade");
            return (Criteria) this;
        }

        public Criteria andReplyGradeNotIn(List<Byte> values) {
            addCriterion("reply_grade not in", values, "replyGrade");
            return (Criteria) this;
        }

        public Criteria andReplyGradeBetween(Byte value1, Byte value2) {
            addCriterion("reply_grade between", value1, value2, "replyGrade");
            return (Criteria) this;
        }

        public Criteria andReplyGradeNotBetween(Byte value1, Byte value2) {
            addCriterion("reply_grade not between", value1, value2, "replyGrade");
            return (Criteria) this;
        }

        public Criteria andTotalGradeIsNull() {
            addCriterion("total_grade is null");
            return (Criteria) this;
        }

        public Criteria andTotalGradeIsNotNull() {
            addCriterion("total_grade is not null");
            return (Criteria) this;
        }

        public Criteria andTotalGradeEqualTo(Byte value) {
            addCriterion("total_grade =", value, "totalGrade");
            return (Criteria) this;
        }

        public Criteria andTotalGradeNotEqualTo(Byte value) {
            addCriterion("total_grade <>", value, "totalGrade");
            return (Criteria) this;
        }

        public Criteria andTotalGradeGreaterThan(Byte value) {
            addCriterion("total_grade >", value, "totalGrade");
            return (Criteria) this;
        }

        public Criteria andTotalGradeGreaterThanOrEqualTo(Byte value) {
            addCriterion("total_grade >=", value, "totalGrade");
            return (Criteria) this;
        }

        public Criteria andTotalGradeLessThan(Byte value) {
            addCriterion("total_grade <", value, "totalGrade");
            return (Criteria) this;
        }

        public Criteria andTotalGradeLessThanOrEqualTo(Byte value) {
            addCriterion("total_grade <=", value, "totalGrade");
            return (Criteria) this;
        }

        public Criteria andTotalGradeIn(List<Byte> values) {
            addCriterion("total_grade in", values, "totalGrade");
            return (Criteria) this;
        }

        public Criteria andTotalGradeNotIn(List<Byte> values) {
            addCriterion("total_grade not in", values, "totalGrade");
            return (Criteria) this;
        }

        public Criteria andTotalGradeBetween(Byte value1, Byte value2) {
            addCriterion("total_grade between", value1, value2, "totalGrade");
            return (Criteria) this;
        }

        public Criteria andTotalGradeNotBetween(Byte value1, Byte value2) {
            addCriterion("total_grade not between", value1, value2, "totalGrade");
            return (Criteria) this;
        }

        public Criteria andGeneralCommentsIsNull() {
            addCriterion("general_comments is null");
            return (Criteria) this;
        }

        public Criteria andGeneralCommentsIsNotNull() {
            addCriterion("general_comments is not null");
            return (Criteria) this;
        }

        public Criteria andGeneralCommentsEqualTo(String value) {
            addCriterion("general_comments =", value, "generalComments");
            return (Criteria) this;
        }

        public Criteria andGeneralCommentsNotEqualTo(String value) {
            addCriterion("general_comments <>", value, "generalComments");
            return (Criteria) this;
        }

        public Criteria andGeneralCommentsGreaterThan(String value) {
            addCriterion("general_comments >", value, "generalComments");
            return (Criteria) this;
        }

        public Criteria andGeneralCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("general_comments >=", value, "generalComments");
            return (Criteria) this;
        }

        public Criteria andGeneralCommentsLessThan(String value) {
            addCriterion("general_comments <", value, "generalComments");
            return (Criteria) this;
        }

        public Criteria andGeneralCommentsLessThanOrEqualTo(String value) {
            addCriterion("general_comments <=", value, "generalComments");
            return (Criteria) this;
        }

        public Criteria andGeneralCommentsLike(String value) {
            addCriterion("general_comments like", value, "generalComments");
            return (Criteria) this;
        }

        public Criteria andGeneralCommentsNotLike(String value) {
            addCriterion("general_comments not like", value, "generalComments");
            return (Criteria) this;
        }

        public Criteria andGeneralCommentsIn(List<String> values) {
            addCriterion("general_comments in", values, "generalComments");
            return (Criteria) this;
        }

        public Criteria andGeneralCommentsNotIn(List<String> values) {
            addCriterion("general_comments not in", values, "generalComments");
            return (Criteria) this;
        }

        public Criteria andGeneralCommentsBetween(String value1, String value2) {
            addCriterion("general_comments between", value1, value2, "generalComments");
            return (Criteria) this;
        }

        public Criteria andGeneralCommentsNotBetween(String value1, String value2) {
            addCriterion("general_comments not between", value1, value2, "generalComments");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}