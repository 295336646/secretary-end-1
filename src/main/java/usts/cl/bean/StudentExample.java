package usts.cl.bean;

import java.util.ArrayList;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(String value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(String value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(String value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(String value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(String value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(String value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLike(String value) {
            addCriterion("sid like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotLike(String value) {
            addCriterion("sid not like", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<String> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<String> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(String value1, String value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(String value1, String value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSnameIsNull() {
            addCriterion("sname is null");
            return (Criteria) this;
        }

        public Criteria andSnameIsNotNull() {
            addCriterion("sname is not null");
            return (Criteria) this;
        }

        public Criteria andSnameEqualTo(String value) {
            addCriterion("sname =", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotEqualTo(String value) {
            addCriterion("sname <>", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThan(String value) {
            addCriterion("sname >", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameGreaterThanOrEqualTo(String value) {
            addCriterion("sname >=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThan(String value) {
            addCriterion("sname <", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLessThanOrEqualTo(String value) {
            addCriterion("sname <=", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameLike(String value) {
            addCriterion("sname like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotLike(String value) {
            addCriterion("sname not like", value, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameIn(List<String> values) {
            addCriterion("sname in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotIn(List<String> values) {
            addCriterion("sname not in", values, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameBetween(String value1, String value2) {
            addCriterion("sname between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSnameNotBetween(String value1, String value2) {
            addCriterion("sname not between", value1, value2, "sname");
            return (Criteria) this;
        }

        public Criteria andSclassIsNull() {
            addCriterion("sclass is null");
            return (Criteria) this;
        }

        public Criteria andSclassIsNotNull() {
            addCriterion("sclass is not null");
            return (Criteria) this;
        }

        public Criteria andSclassEqualTo(String value) {
            addCriterion("sclass =", value, "sclass");
            return (Criteria) this;
        }

        public Criteria andSclassNotEqualTo(String value) {
            addCriterion("sclass <>", value, "sclass");
            return (Criteria) this;
        }

        public Criteria andSclassGreaterThan(String value) {
            addCriterion("sclass >", value, "sclass");
            return (Criteria) this;
        }

        public Criteria andSclassGreaterThanOrEqualTo(String value) {
            addCriterion("sclass >=", value, "sclass");
            return (Criteria) this;
        }

        public Criteria andSclassLessThan(String value) {
            addCriterion("sclass <", value, "sclass");
            return (Criteria) this;
        }

        public Criteria andSclassLessThanOrEqualTo(String value) {
            addCriterion("sclass <=", value, "sclass");
            return (Criteria) this;
        }

        public Criteria andSclassLike(String value) {
            addCriterion("sclass like", value, "sclass");
            return (Criteria) this;
        }

        public Criteria andSclassNotLike(String value) {
            addCriterion("sclass not like", value, "sclass");
            return (Criteria) this;
        }

        public Criteria andSclassIn(List<String> values) {
            addCriterion("sclass in", values, "sclass");
            return (Criteria) this;
        }

        public Criteria andSclassNotIn(List<String> values) {
            addCriterion("sclass not in", values, "sclass");
            return (Criteria) this;
        }

        public Criteria andSclassBetween(String value1, String value2) {
            addCriterion("sclass between", value1, value2, "sclass");
            return (Criteria) this;
        }

        public Criteria andSclassNotBetween(String value1, String value2) {
            addCriterion("sclass not between", value1, value2, "sclass");
            return (Criteria) this;
        }

        public Criteria andSgroupIsNull() {
            addCriterion("sgroup is null");
            return (Criteria) this;
        }

        public Criteria andSgroupIsNotNull() {
            addCriterion("sgroup is not null");
            return (Criteria) this;
        }

        public Criteria andSgroupEqualTo(Integer value) {
            addCriterion("sgroup =", value, "sgroup");
            return (Criteria) this;
        }

        public Criteria andSgroupNotEqualTo(Integer value) {
            addCriterion("sgroup <>", value, "sgroup");
            return (Criteria) this;
        }

        public Criteria andSgroupGreaterThan(Integer value) {
            addCriterion("sgroup >", value, "sgroup");
            return (Criteria) this;
        }

        public Criteria andSgroupGreaterThanOrEqualTo(Integer value) {
            addCriterion("sgroup >=", value, "sgroup");
            return (Criteria) this;
        }

        public Criteria andSgroupLessThan(Integer value) {
            addCriterion("sgroup <", value, "sgroup");
            return (Criteria) this;
        }

        public Criteria andSgroupLessThanOrEqualTo(Integer value) {
            addCriterion("sgroup <=", value, "sgroup");
            return (Criteria) this;
        }

        public Criteria andSgroupIn(List<Integer> values) {
            addCriterion("sgroup in", values, "sgroup");
            return (Criteria) this;
        }

        public Criteria andSgroupNotIn(List<Integer> values) {
            addCriterion("sgroup not in", values, "sgroup");
            return (Criteria) this;
        }

        public Criteria andSgroupBetween(Integer value1, Integer value2) {
            addCriterion("sgroup between", value1, value2, "sgroup");
            return (Criteria) this;
        }

        public Criteria andSgroupNotBetween(Integer value1, Integer value2) {
            addCriterion("sgroup not between", value1, value2, "sgroup");
            return (Criteria) this;
        }

        public Criteria andCnoIsNull() {
            addCriterion("cno is null");
            return (Criteria) this;
        }

        public Criteria andCnoIsNotNull() {
            addCriterion("cno is not null");
            return (Criteria) this;
        }

        public Criteria andCnoEqualTo(Integer value) {
            addCriterion("cno =", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotEqualTo(Integer value) {
            addCriterion("cno <>", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoGreaterThan(Integer value) {
            addCriterion("cno >", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("cno >=", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoLessThan(Integer value) {
            addCriterion("cno <", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoLessThanOrEqualTo(Integer value) {
            addCriterion("cno <=", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoIn(List<Integer> values) {
            addCriterion("cno in", values, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotIn(List<Integer> values) {
            addCriterion("cno not in", values, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoBetween(Integer value1, Integer value2) {
            addCriterion("cno between", value1, value2, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotBetween(Integer value1, Integer value2) {
            addCriterion("cno not between", value1, value2, "cno");
            return (Criteria) this;
        }

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(String value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(String value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(String value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(String value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(String value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(String value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLike(String value) {
            addCriterion("tid like", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotLike(String value) {
            addCriterion("tid not like", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<String> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<String> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(String value1, String value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(String value1, String value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTjudgeIsNull() {
            addCriterion("tjudge is null");
            return (Criteria) this;
        }

        public Criteria andTjudgeIsNotNull() {
            addCriterion("tjudge is not null");
            return (Criteria) this;
        }

        public Criteria andTjudgeEqualTo(String value) {
            addCriterion("tjudge =", value, "tjudge");
            return (Criteria) this;
        }

        public Criteria andTjudgeNotEqualTo(String value) {
            addCriterion("tjudge <>", value, "tjudge");
            return (Criteria) this;
        }

        public Criteria andTjudgeGreaterThan(String value) {
            addCriterion("tjudge >", value, "tjudge");
            return (Criteria) this;
        }

        public Criteria andTjudgeGreaterThanOrEqualTo(String value) {
            addCriterion("tjudge >=", value, "tjudge");
            return (Criteria) this;
        }

        public Criteria andTjudgeLessThan(String value) {
            addCriterion("tjudge <", value, "tjudge");
            return (Criteria) this;
        }

        public Criteria andTjudgeLessThanOrEqualTo(String value) {
            addCriterion("tjudge <=", value, "tjudge");
            return (Criteria) this;
        }

        public Criteria andTjudgeLike(String value) {
            addCriterion("tjudge like", value, "tjudge");
            return (Criteria) this;
        }

        public Criteria andTjudgeNotLike(String value) {
            addCriterion("tjudge not like", value, "tjudge");
            return (Criteria) this;
        }

        public Criteria andTjudgeIn(List<String> values) {
            addCriterion("tjudge in", values, "tjudge");
            return (Criteria) this;
        }

        public Criteria andTjudgeNotIn(List<String> values) {
            addCriterion("tjudge not in", values, "tjudge");
            return (Criteria) this;
        }

        public Criteria andTjudgeBetween(String value1, String value2) {
            addCriterion("tjudge between", value1, value2, "tjudge");
            return (Criteria) this;
        }

        public Criteria andTjudgeNotBetween(String value1, String value2) {
            addCriterion("tjudge not between", value1, value2, "tjudge");
            return (Criteria) this;
        }

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(Integer value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(Integer value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(Integer value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(Integer value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(Integer value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<Integer> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<Integer> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(Integer value1, Integer value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(Integer value1, Integer value2) {
            addCriterion("gid not between", value1, value2, "gid");
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