package com.ihospital.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PathographyExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PathographyExample() {
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

        public Criteria andPathoIdIsNull() {
            addCriterion("patho_id is null");
            return (Criteria) this;
        }

        public Criteria andPathoIdIsNotNull() {
            addCriterion("patho_id is not null");
            return (Criteria) this;
        }

        public Criteria andPathoIdEqualTo(Long value) {
            addCriterion("patho_id =", value, "pathoId");
            return (Criteria) this;
        }

        public Criteria andPathoIdNotEqualTo(Long value) {
            addCriterion("patho_id <>", value, "pathoId");
            return (Criteria) this;
        }

        public Criteria andPathoIdGreaterThan(Long value) {
            addCriterion("patho_id >", value, "pathoId");
            return (Criteria) this;
        }

        public Criteria andPathoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("patho_id >=", value, "pathoId");
            return (Criteria) this;
        }

        public Criteria andPathoIdLessThan(Long value) {
            addCriterion("patho_id <", value, "pathoId");
            return (Criteria) this;
        }

        public Criteria andPathoIdLessThanOrEqualTo(Long value) {
            addCriterion("patho_id <=", value, "pathoId");
            return (Criteria) this;
        }

        public Criteria andPathoIdIn(List<Long> values) {
            addCriterion("patho_id in", values, "pathoId");
            return (Criteria) this;
        }

        public Criteria andPathoIdNotIn(List<Long> values) {
            addCriterion("patho_id not in", values, "pathoId");
            return (Criteria) this;
        }

        public Criteria andPathoIdBetween(Long value1, Long value2) {
            addCriterion("patho_id between", value1, value2, "pathoId");
            return (Criteria) this;
        }

        public Criteria andPathoIdNotBetween(Long value1, Long value2) {
            addCriterion("patho_id not between", value1, value2, "pathoId");
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

        public Criteria andDiagnosisIsNull() {
            addCriterion("diagnosis is null");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIsNotNull() {
            addCriterion("diagnosis is not null");
            return (Criteria) this;
        }

        public Criteria andDiagnosisEqualTo(String value) {
            addCriterion("diagnosis =", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNotEqualTo(String value) {
            addCriterion("diagnosis <>", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisGreaterThan(String value) {
            addCriterion("diagnosis >", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisGreaterThanOrEqualTo(String value) {
            addCriterion("diagnosis >=", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisLessThan(String value) {
            addCriterion("diagnosis <", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisLessThanOrEqualTo(String value) {
            addCriterion("diagnosis <=", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisLike(String value) {
            addCriterion("diagnosis like", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNotLike(String value) {
            addCriterion("diagnosis not like", value, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisIn(List<String> values) {
            addCriterion("diagnosis in", values, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNotIn(List<String> values) {
            addCriterion("diagnosis not in", values, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisBetween(String value1, String value2) {
            addCriterion("diagnosis between", value1, value2, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andDiagnosisNotBetween(String value1, String value2) {
            addCriterion("diagnosis not between", value1, value2, "diagnosis");
            return (Criteria) this;
        }

        public Criteria andNarrativeIsNull() {
            addCriterion("narrative is null");
            return (Criteria) this;
        }

        public Criteria andNarrativeIsNotNull() {
            addCriterion("narrative is not null");
            return (Criteria) this;
        }

        public Criteria andNarrativeEqualTo(String value) {
            addCriterion("narrative =", value, "narrative");
            return (Criteria) this;
        }

        public Criteria andNarrativeNotEqualTo(String value) {
            addCriterion("narrative <>", value, "narrative");
            return (Criteria) this;
        }

        public Criteria andNarrativeGreaterThan(String value) {
            addCriterion("narrative >", value, "narrative");
            return (Criteria) this;
        }

        public Criteria andNarrativeGreaterThanOrEqualTo(String value) {
            addCriterion("narrative >=", value, "narrative");
            return (Criteria) this;
        }

        public Criteria andNarrativeLessThan(String value) {
            addCriterion("narrative <", value, "narrative");
            return (Criteria) this;
        }

        public Criteria andNarrativeLessThanOrEqualTo(String value) {
            addCriterion("narrative <=", value, "narrative");
            return (Criteria) this;
        }

        public Criteria andNarrativeLike(String value) {
            addCriterion("narrative like", value, "narrative");
            return (Criteria) this;
        }

        public Criteria andNarrativeNotLike(String value) {
            addCriterion("narrative not like", value, "narrative");
            return (Criteria) this;
        }

        public Criteria andNarrativeIn(List<String> values) {
            addCriterion("narrative in", values, "narrative");
            return (Criteria) this;
        }

        public Criteria andNarrativeNotIn(List<String> values) {
            addCriterion("narrative not in", values, "narrative");
            return (Criteria) this;
        }

        public Criteria andNarrativeBetween(String value1, String value2) {
            addCriterion("narrative between", value1, value2, "narrative");
            return (Criteria) this;
        }

        public Criteria andNarrativeNotBetween(String value1, String value2) {
            addCriterion("narrative not between", value1, value2, "narrative");
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

        public Criteria andPathoValidIsNull() {
            addCriterion("patho_valid is null");
            return (Criteria) this;
        }

        public Criteria andPathoValidIsNotNull() {
            addCriterion("patho_valid is not null");
            return (Criteria) this;
        }

        public Criteria andPathoValidEqualTo(Boolean value) {
            addCriterion("patho_valid =", value, "pathoValid");
            return (Criteria) this;
        }

        public Criteria andPathoValidNotEqualTo(Boolean value) {
            addCriterion("patho_valid <>", value, "pathoValid");
            return (Criteria) this;
        }

        public Criteria andPathoValidGreaterThan(Boolean value) {
            addCriterion("patho_valid >", value, "pathoValid");
            return (Criteria) this;
        }

        public Criteria andPathoValidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("patho_valid >=", value, "pathoValid");
            return (Criteria) this;
        }

        public Criteria andPathoValidLessThan(Boolean value) {
            addCriterion("patho_valid <", value, "pathoValid");
            return (Criteria) this;
        }

        public Criteria andPathoValidLessThanOrEqualTo(Boolean value) {
            addCriterion("patho_valid <=", value, "pathoValid");
            return (Criteria) this;
        }

        public Criteria andPathoValidIn(List<Boolean> values) {
            addCriterion("patho_valid in", values, "pathoValid");
            return (Criteria) this;
        }

        public Criteria andPathoValidNotIn(List<Boolean> values) {
            addCriterion("patho_valid not in", values, "pathoValid");
            return (Criteria) this;
        }

        public Criteria andPathoValidBetween(Boolean value1, Boolean value2) {
            addCriterion("patho_valid between", value1, value2, "pathoValid");
            return (Criteria) this;
        }

        public Criteria andPathoValidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("patho_valid not between", value1, value2, "pathoValid");
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