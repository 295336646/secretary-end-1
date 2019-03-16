package usts.cl.bean;

import java.util.ArrayList;
import java.util.List;

public class ReplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReplyExample() {
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

        public Criteria andSubjectNameIsNull() {
            addCriterion("subject_name is null");
            return (Criteria) this;
        }

        public Criteria andSubjectNameIsNotNull() {
            addCriterion("subject_name is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectNameEqualTo(String value) {
            addCriterion("subject_name =", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameNotEqualTo(String value) {
            addCriterion("subject_name <>", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameGreaterThan(String value) {
            addCriterion("subject_name >", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("subject_name >=", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameLessThan(String value) {
            addCriterion("subject_name <", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameLessThanOrEqualTo(String value) {
            addCriterion("subject_name <=", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameLike(String value) {
            addCriterion("subject_name like", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameNotLike(String value) {
            addCriterion("subject_name not like", value, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameIn(List<String> values) {
            addCriterion("subject_name in", values, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameNotIn(List<String> values) {
            addCriterion("subject_name not in", values, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameBetween(String value1, String value2) {
            addCriterion("subject_name between", value1, value2, "subjectName");
            return (Criteria) this;
        }

        public Criteria andSubjectNameNotBetween(String value1, String value2) {
            addCriterion("subject_name not between", value1, value2, "subjectName");
            return (Criteria) this;
        }

        public Criteria andStudentIsNull() {
            addCriterion("student is null");
            return (Criteria) this;
        }

        public Criteria andStudentIsNotNull() {
            addCriterion("student is not null");
            return (Criteria) this;
        }

        public Criteria andStudentEqualTo(String value) {
            addCriterion("student =", value, "student");
            return (Criteria) this;
        }

        public Criteria andStudentNotEqualTo(String value) {
            addCriterion("student <>", value, "student");
            return (Criteria) this;
        }

        public Criteria andStudentGreaterThan(String value) {
            addCriterion("student >", value, "student");
            return (Criteria) this;
        }

        public Criteria andStudentGreaterThanOrEqualTo(String value) {
            addCriterion("student >=", value, "student");
            return (Criteria) this;
        }

        public Criteria andStudentLessThan(String value) {
            addCriterion("student <", value, "student");
            return (Criteria) this;
        }

        public Criteria andStudentLessThanOrEqualTo(String value) {
            addCriterion("student <=", value, "student");
            return (Criteria) this;
        }

        public Criteria andStudentLike(String value) {
            addCriterion("student like", value, "student");
            return (Criteria) this;
        }

        public Criteria andStudentNotLike(String value) {
            addCriterion("student not like", value, "student");
            return (Criteria) this;
        }

        public Criteria andStudentIn(List<String> values) {
            addCriterion("student in", values, "student");
            return (Criteria) this;
        }

        public Criteria andStudentNotIn(List<String> values) {
            addCriterion("student not in", values, "student");
            return (Criteria) this;
        }

        public Criteria andStudentBetween(String value1, String value2) {
            addCriterion("student between", value1, value2, "student");
            return (Criteria) this;
        }

        public Criteria andStudentNotBetween(String value1, String value2) {
            addCriterion("student not between", value1, value2, "student");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIsNull() {
            addCriterion("subject_type is null");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIsNotNull() {
            addCriterion("subject_type is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeEqualTo(String value) {
            addCriterion("subject_type =", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotEqualTo(String value) {
            addCriterion("subject_type <>", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeGreaterThan(String value) {
            addCriterion("subject_type >", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("subject_type >=", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLessThan(String value) {
            addCriterion("subject_type <", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLessThanOrEqualTo(String value) {
            addCriterion("subject_type <=", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLike(String value) {
            addCriterion("subject_type like", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotLike(String value) {
            addCriterion("subject_type not like", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIn(List<String> values) {
            addCriterion("subject_type in", values, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotIn(List<String> values) {
            addCriterion("subject_type not in", values, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeBetween(String value1, String value2) {
            addCriterion("subject_type between", value1, value2, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotBetween(String value1, String value2) {
            addCriterion("subject_type not between", value1, value2, "subjectType");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreIsNull() {
            addCriterion("guidance_score is null");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreIsNotNull() {
            addCriterion("guidance_score is not null");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreEqualTo(Byte value) {
            addCriterion("guidance_score =", value, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreNotEqualTo(Byte value) {
            addCriterion("guidance_score <>", value, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreGreaterThan(Byte value) {
            addCriterion("guidance_score >", value, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreGreaterThanOrEqualTo(Byte value) {
            addCriterion("guidance_score >=", value, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreLessThan(Byte value) {
            addCriterion("guidance_score <", value, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreLessThanOrEqualTo(Byte value) {
            addCriterion("guidance_score <=", value, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreIn(List<Byte> values) {
            addCriterion("guidance_score in", values, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreNotIn(List<Byte> values) {
            addCriterion("guidance_score not in", values, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreBetween(Byte value1, Byte value2) {
            addCriterion("guidance_score between", value1, value2, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andGuidanceScoreNotBetween(Byte value1, Byte value2) {
            addCriterion("guidance_score not between", value1, value2, "guidanceScore");
            return (Criteria) this;
        }

        public Criteria andRatingScoreIsNull() {
            addCriterion("rating_score is null");
            return (Criteria) this;
        }

        public Criteria andRatingScoreIsNotNull() {
            addCriterion("rating_score is not null");
            return (Criteria) this;
        }

        public Criteria andRatingScoreEqualTo(Byte value) {
            addCriterion("rating_score =", value, "ratingScore");
            return (Criteria) this;
        }

        public Criteria andRatingScoreNotEqualTo(Byte value) {
            addCriterion("rating_score <>", value, "ratingScore");
            return (Criteria) this;
        }

        public Criteria andRatingScoreGreaterThan(Byte value) {
            addCriterion("rating_score >", value, "ratingScore");
            return (Criteria) this;
        }

        public Criteria andRatingScoreGreaterThanOrEqualTo(Byte value) {
            addCriterion("rating_score >=", value, "ratingScore");
            return (Criteria) this;
        }

        public Criteria andRatingScoreLessThan(Byte value) {
            addCriterion("rating_score <", value, "ratingScore");
            return (Criteria) this;
        }

        public Criteria andRatingScoreLessThanOrEqualTo(Byte value) {
            addCriterion("rating_score <=", value, "ratingScore");
            return (Criteria) this;
        }

        public Criteria andRatingScoreIn(List<Byte> values) {
            addCriterion("rating_score in", values, "ratingScore");
            return (Criteria) this;
        }

        public Criteria andRatingScoreNotIn(List<Byte> values) {
            addCriterion("rating_score not in", values, "ratingScore");
            return (Criteria) this;
        }

        public Criteria andRatingScoreBetween(Byte value1, Byte value2) {
            addCriterion("rating_score between", value1, value2, "ratingScore");
            return (Criteria) this;
        }

        public Criteria andRatingScoreNotBetween(Byte value1, Byte value2) {
            addCriterion("rating_score not between", value1, value2, "ratingScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreIsNull() {
            addCriterion("reply_score is null");
            return (Criteria) this;
        }

        public Criteria andReplyScoreIsNotNull() {
            addCriterion("reply_score is not null");
            return (Criteria) this;
        }

        public Criteria andReplyScoreEqualTo(Byte value) {
            addCriterion("reply_score =", value, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreNotEqualTo(Byte value) {
            addCriterion("reply_score <>", value, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreGreaterThan(Byte value) {
            addCriterion("reply_score >", value, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreGreaterThanOrEqualTo(Byte value) {
            addCriterion("reply_score >=", value, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreLessThan(Byte value) {
            addCriterion("reply_score <", value, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreLessThanOrEqualTo(Byte value) {
            addCriterion("reply_score <=", value, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreIn(List<Byte> values) {
            addCriterion("reply_score in", values, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreNotIn(List<Byte> values) {
            addCriterion("reply_score not in", values, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreBetween(Byte value1, Byte value2) {
            addCriterion("reply_score between", value1, value2, "replyScore");
            return (Criteria) this;
        }

        public Criteria andReplyScoreNotBetween(Byte value1, Byte value2) {
            addCriterion("reply_score not between", value1, value2, "replyScore");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
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