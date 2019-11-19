package com.ihospital.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultationExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConsultationExample() {
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

        public Criteria andConsultIdIsNull() {
            addCriterion("consult_id is null");
            return (Criteria) this;
        }

        public Criteria andConsultIdIsNotNull() {
            addCriterion("consult_id is not null");
            return (Criteria) this;
        }

        public Criteria andConsultIdEqualTo(Long value) {
            addCriterion("consult_id =", value, "consultId");
            return (Criteria) this;
        }

        public Criteria andConsultIdNotEqualTo(Long value) {
            addCriterion("consult_id <>", value, "consultId");
            return (Criteria) this;
        }

        public Criteria andConsultIdGreaterThan(Long value) {
            addCriterion("consult_id >", value, "consultId");
            return (Criteria) this;
        }

        public Criteria andConsultIdGreaterThanOrEqualTo(Long value) {
            addCriterion("consult_id >=", value, "consultId");
            return (Criteria) this;
        }

        public Criteria andConsultIdLessThan(Long value) {
            addCriterion("consult_id <", value, "consultId");
            return (Criteria) this;
        }

        public Criteria andConsultIdLessThanOrEqualTo(Long value) {
            addCriterion("consult_id <=", value, "consultId");
            return (Criteria) this;
        }

        public Criteria andConsultIdIn(List<Long> values) {
            addCriterion("consult_id in", values, "consultId");
            return (Criteria) this;
        }

        public Criteria andConsultIdNotIn(List<Long> values) {
            addCriterion("consult_id not in", values, "consultId");
            return (Criteria) this;
        }

        public Criteria andConsultIdBetween(Long value1, Long value2) {
            addCriterion("consult_id between", value1, value2, "consultId");
            return (Criteria) this;
        }

        public Criteria andConsultIdNotBetween(Long value1, Long value2) {
            addCriterion("consult_id not between", value1, value2, "consultId");
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

        public Criteria andBodyIsNull() {
            addCriterion("body is null");
            return (Criteria) this;
        }

        public Criteria andBodyIsNotNull() {
            addCriterion("body is not null");
            return (Criteria) this;
        }

        public Criteria andBodyEqualTo(String value) {
            addCriterion("body =", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotEqualTo(String value) {
            addCriterion("body <>", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThan(String value) {
            addCriterion("body >", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThanOrEqualTo(String value) {
            addCriterion("body >=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThan(String value) {
            addCriterion("body <", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThanOrEqualTo(String value) {
            addCriterion("body <=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLike(String value) {
            addCriterion("body like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotLike(String value) {
            addCriterion("body not like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyIn(List<String> values) {
            addCriterion("body in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotIn(List<String> values) {
            addCriterion("body not in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyBetween(String value1, String value2) {
            addCriterion("body between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotBetween(String value1, String value2) {
            addCriterion("body not between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLastEditTimeIsNull() {
            addCriterion("last_edit_time is null");
            return (Criteria) this;
        }

        public Criteria andLastEditTimeIsNotNull() {
            addCriterion("last_edit_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastEditTimeEqualTo(Date value) {
            addCriterion("last_edit_time =", value, "lastEditTime");
            return (Criteria) this;
        }

        public Criteria andLastEditTimeNotEqualTo(Date value) {
            addCriterion("last_edit_time <>", value, "lastEditTime");
            return (Criteria) this;
        }

        public Criteria andLastEditTimeGreaterThan(Date value) {
            addCriterion("last_edit_time >", value, "lastEditTime");
            return (Criteria) this;
        }

        public Criteria andLastEditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_edit_time >=", value, "lastEditTime");
            return (Criteria) this;
        }

        public Criteria andLastEditTimeLessThan(Date value) {
            addCriterion("last_edit_time <", value, "lastEditTime");
            return (Criteria) this;
        }

        public Criteria andLastEditTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_edit_time <=", value, "lastEditTime");
            return (Criteria) this;
        }

        public Criteria andLastEditTimeIn(List<Date> values) {
            addCriterion("last_edit_time in", values, "lastEditTime");
            return (Criteria) this;
        }

        public Criteria andLastEditTimeNotIn(List<Date> values) {
            addCriterion("last_edit_time not in", values, "lastEditTime");
            return (Criteria) this;
        }

        public Criteria andLastEditTimeBetween(Date value1, Date value2) {
            addCriterion("last_edit_time between", value1, value2, "lastEditTime");
            return (Criteria) this;
        }

        public Criteria andLastEditTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_edit_time not between", value1, value2, "lastEditTime");
            return (Criteria) this;
        }

        public Criteria andReplyCountIsNull() {
            addCriterion("reply_count is null");
            return (Criteria) this;
        }

        public Criteria andReplyCountIsNotNull() {
            addCriterion("reply_count is not null");
            return (Criteria) this;
        }

        public Criteria andReplyCountEqualTo(Integer value) {
            addCriterion("reply_count =", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountNotEqualTo(Integer value) {
            addCriterion("reply_count <>", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountGreaterThan(Integer value) {
            addCriterion("reply_count >", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_count >=", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountLessThan(Integer value) {
            addCriterion("reply_count <", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountLessThanOrEqualTo(Integer value) {
            addCriterion("reply_count <=", value, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountIn(List<Integer> values) {
            addCriterion("reply_count in", values, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountNotIn(List<Integer> values) {
            addCriterion("reply_count not in", values, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountBetween(Integer value1, Integer value2) {
            addCriterion("reply_count between", value1, value2, "replyCount");
            return (Criteria) this;
        }

        public Criteria andReplyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_count not between", value1, value2, "replyCount");
            return (Criteria) this;
        }

        public Criteria andLastReplyIdIsNull() {
            addCriterion("last_reply_id is null");
            return (Criteria) this;
        }

        public Criteria andLastReplyIdIsNotNull() {
            addCriterion("last_reply_id is not null");
            return (Criteria) this;
        }

        public Criteria andLastReplyIdEqualTo(Integer value) {
            addCriterion("last_reply_id =", value, "lastReplyId");
            return (Criteria) this;
        }

        public Criteria andLastReplyIdNotEqualTo(Integer value) {
            addCriterion("last_reply_id <>", value, "lastReplyId");
            return (Criteria) this;
        }

        public Criteria andLastReplyIdGreaterThan(Integer value) {
            addCriterion("last_reply_id >", value, "lastReplyId");
            return (Criteria) this;
        }

        public Criteria andLastReplyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_reply_id >=", value, "lastReplyId");
            return (Criteria) this;
        }

        public Criteria andLastReplyIdLessThan(Integer value) {
            addCriterion("last_reply_id <", value, "lastReplyId");
            return (Criteria) this;
        }

        public Criteria andLastReplyIdLessThanOrEqualTo(Integer value) {
            addCriterion("last_reply_id <=", value, "lastReplyId");
            return (Criteria) this;
        }

        public Criteria andLastReplyIdIn(List<Integer> values) {
            addCriterion("last_reply_id in", values, "lastReplyId");
            return (Criteria) this;
        }

        public Criteria andLastReplyIdNotIn(List<Integer> values) {
            addCriterion("last_reply_id not in", values, "lastReplyId");
            return (Criteria) this;
        }

        public Criteria andLastReplyIdBetween(Integer value1, Integer value2) {
            addCriterion("last_reply_id between", value1, value2, "lastReplyId");
            return (Criteria) this;
        }

        public Criteria andLastReplyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("last_reply_id not between", value1, value2, "lastReplyId");
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