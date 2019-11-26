package com.ihospital.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LikesExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LikesExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andLikeIdIsNull() {
            addCriterion("like_id is null");
            return (Criteria) this;
        }

        public Criteria andLikeIdIsNotNull() {
            addCriterion("like_id is not null");
            return (Criteria) this;
        }

        public Criteria andLikeIdEqualTo(Long value) {
            addCriterion("like_id =", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdNotEqualTo(Long value) {
            addCriterion("like_id <>", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdGreaterThan(Long value) {
            addCriterion("like_id >", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("like_id >=", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdLessThan(Long value) {
            addCriterion("like_id <", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdLessThanOrEqualTo(Long value) {
            addCriterion("like_id <=", value, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdIn(List<Long> values) {
            addCriterion("like_id in", values, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdNotIn(List<Long> values) {
            addCriterion("like_id not in", values, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdBetween(Long value1, Long value2) {
            addCriterion("like_id between", value1, value2, "likeId");
            return (Criteria) this;
        }

        public Criteria andLikeIdNotBetween(Long value1, Long value2) {
            addCriterion("like_id not between", value1, value2, "likeId");
            return (Criteria) this;
        }

        public Criteria andPhysicianIdIsNull() {
            addCriterion("physician_id is null");
            return (Criteria) this;
        }

        public Criteria andPhysicianIdIsNotNull() {
            addCriterion("physician_id is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicianIdEqualTo(Long value) {
            addCriterion("physician_id =", value, "physicianId");
            return (Criteria) this;
        }

        public Criteria andPhysicianIdNotEqualTo(Long value) {
            addCriterion("physician_id <>", value, "physicianId");
            return (Criteria) this;
        }

        public Criteria andPhysicianIdGreaterThan(Long value) {
            addCriterion("physician_id >", value, "physicianId");
            return (Criteria) this;
        }

        public Criteria andPhysicianIdGreaterThanOrEqualTo(Long value) {
            addCriterion("physician_id >=", value, "physicianId");
            return (Criteria) this;
        }

        public Criteria andPhysicianIdLessThan(Long value) {
            addCriterion("physician_id <", value, "physicianId");
            return (Criteria) this;
        }

        public Criteria andPhysicianIdLessThanOrEqualTo(Long value) {
            addCriterion("physician_id <=", value, "physicianId");
            return (Criteria) this;
        }

        public Criteria andPhysicianIdIn(List<Long> values) {
            addCriterion("physician_id in", values, "physicianId");
            return (Criteria) this;
        }

        public Criteria andPhysicianIdNotIn(List<Long> values) {
            addCriterion("physician_id not in", values, "physicianId");
            return (Criteria) this;
        }

        public Criteria andPhysicianIdBetween(Long value1, Long value2) {
            addCriterion("physician_id between", value1, value2, "physicianId");
            return (Criteria) this;
        }

        public Criteria andPhysicianIdNotBetween(Long value1, Long value2) {
            addCriterion("physician_id not between", value1, value2, "physicianId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNull() {
            addCriterion("patient_id is null");
            return (Criteria) this;
        }

        public Criteria andPatientIdIsNotNull() {
            addCriterion("patient_id is not null");
            return (Criteria) this;
        }

        public Criteria andPatientIdEqualTo(Long value) {
            addCriterion("patient_id =", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotEqualTo(Long value) {
            addCriterion("patient_id <>", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThan(Long value) {
            addCriterion("patient_id >", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdGreaterThanOrEqualTo(Long value) {
            addCriterion("patient_id >=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThan(Long value) {
            addCriterion("patient_id <", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdLessThanOrEqualTo(Long value) {
            addCriterion("patient_id <=", value, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdIn(List<Long> values) {
            addCriterion("patient_id in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotIn(List<Long> values) {
            addCriterion("patient_id not in", values, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdBetween(Long value1, Long value2) {
            addCriterion("patient_id between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andPatientIdNotBetween(Long value1, Long value2) {
            addCriterion("patient_id not between", value1, value2, "patientId");
            return (Criteria) this;
        }

        public Criteria andLikeDateIsNull() {
            addCriterion("like_date is null");
            return (Criteria) this;
        }

        public Criteria andLikeDateIsNotNull() {
            addCriterion("like_date is not null");
            return (Criteria) this;
        }

        public Criteria andLikeDateEqualTo(Date value) {
            addCriterionForJDBCDate("like_date =", value, "likeDate");
            return (Criteria) this;
        }

        public Criteria andLikeDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("like_date <>", value, "likeDate");
            return (Criteria) this;
        }

        public Criteria andLikeDateGreaterThan(Date value) {
            addCriterionForJDBCDate("like_date >", value, "likeDate");
            return (Criteria) this;
        }

        public Criteria andLikeDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("like_date >=", value, "likeDate");
            return (Criteria) this;
        }

        public Criteria andLikeDateLessThan(Date value) {
            addCriterionForJDBCDate("like_date <", value, "likeDate");
            return (Criteria) this;
        }

        public Criteria andLikeDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("like_date <=", value, "likeDate");
            return (Criteria) this;
        }

        public Criteria andLikeDateIn(List<Date> values) {
            addCriterionForJDBCDate("like_date in", values, "likeDate");
            return (Criteria) this;
        }

        public Criteria andLikeDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("like_date not in", values, "likeDate");
            return (Criteria) this;
        }

        public Criteria andLikeDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("like_date between", value1, value2, "likeDate");
            return (Criteria) this;
        }

        public Criteria andLikeDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("like_date not between", value1, value2, "likeDate");
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