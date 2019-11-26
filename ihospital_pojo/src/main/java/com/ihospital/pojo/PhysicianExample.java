package com.ihospital.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PhysicianExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PhysicianExample() {
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

        public Criteria andPhysicianNameIsNull() {
            addCriterion("physician_name is null");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameIsNotNull() {
            addCriterion("physician_name is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameEqualTo(String value) {
            addCriterion("physician_name =", value, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameNotEqualTo(String value) {
            addCriterion("physician_name <>", value, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameGreaterThan(String value) {
            addCriterion("physician_name >", value, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameGreaterThanOrEqualTo(String value) {
            addCriterion("physician_name >=", value, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameLessThan(String value) {
            addCriterion("physician_name <", value, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameLessThanOrEqualTo(String value) {
            addCriterion("physician_name <=", value, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameLike(String value) {
            addCriterion("physician_name like", value, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameNotLike(String value) {
            addCriterion("physician_name not like", value, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameIn(List<String> values) {
            addCriterion("physician_name in", values, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameNotIn(List<String> values) {
            addCriterion("physician_name not in", values, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameBetween(String value1, String value2) {
            addCriterion("physician_name between", value1, value2, "physicianName");
            return (Criteria) this;
        }

        public Criteria andPhysicianNameNotBetween(String value1, String value2) {
            addCriterion("physician_name not between", value1, value2, "physicianName");
            return (Criteria) this;
        }

        public Criteria andWorktitleIsNull() {
            addCriterion("worktitle is null");
            return (Criteria) this;
        }

        public Criteria andWorktitleIsNotNull() {
            addCriterion("worktitle is not null");
            return (Criteria) this;
        }

        public Criteria andWorktitleEqualTo(String value) {
            addCriterion("worktitle =", value, "worktitle");
            return (Criteria) this;
        }

        public Criteria andWorktitleNotEqualTo(String value) {
            addCriterion("worktitle <>", value, "worktitle");
            return (Criteria) this;
        }

        public Criteria andWorktitleGreaterThan(String value) {
            addCriterion("worktitle >", value, "worktitle");
            return (Criteria) this;
        }

        public Criteria andWorktitleGreaterThanOrEqualTo(String value) {
            addCriterion("worktitle >=", value, "worktitle");
            return (Criteria) this;
        }

        public Criteria andWorktitleLessThan(String value) {
            addCriterion("worktitle <", value, "worktitle");
            return (Criteria) this;
        }

        public Criteria andWorktitleLessThanOrEqualTo(String value) {
            addCriterion("worktitle <=", value, "worktitle");
            return (Criteria) this;
        }

        public Criteria andWorktitleLike(String value) {
            addCriterion("worktitle like", value, "worktitle");
            return (Criteria) this;
        }

        public Criteria andWorktitleNotLike(String value) {
            addCriterion("worktitle not like", value, "worktitle");
            return (Criteria) this;
        }

        public Criteria andWorktitleIn(List<String> values) {
            addCriterion("worktitle in", values, "worktitle");
            return (Criteria) this;
        }

        public Criteria andWorktitleNotIn(List<String> values) {
            addCriterion("worktitle not in", values, "worktitle");
            return (Criteria) this;
        }

        public Criteria andWorktitleBetween(String value1, String value2) {
            addCriterion("worktitle between", value1, value2, "worktitle");
            return (Criteria) this;
        }

        public Criteria andWorktitleNotBetween(String value1, String value2) {
            addCriterion("worktitle not between", value1, value2, "worktitle");
            return (Criteria) this;
        }

        public Criteria andPhysicianAgeIsNull() {
            addCriterion("physician_age is null");
            return (Criteria) this;
        }

        public Criteria andPhysicianAgeIsNotNull() {
            addCriterion("physician_age is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicianAgeEqualTo(Integer value) {
            addCriterion("physician_age =", value, "physicianAge");
            return (Criteria) this;
        }

        public Criteria andPhysicianAgeNotEqualTo(Integer value) {
            addCriterion("physician_age <>", value, "physicianAge");
            return (Criteria) this;
        }

        public Criteria andPhysicianAgeGreaterThan(Integer value) {
            addCriterion("physician_age >", value, "physicianAge");
            return (Criteria) this;
        }

        public Criteria andPhysicianAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("physician_age >=", value, "physicianAge");
            return (Criteria) this;
        }

        public Criteria andPhysicianAgeLessThan(Integer value) {
            addCriterion("physician_age <", value, "physicianAge");
            return (Criteria) this;
        }

        public Criteria andPhysicianAgeLessThanOrEqualTo(Integer value) {
            addCriterion("physician_age <=", value, "physicianAge");
            return (Criteria) this;
        }

        public Criteria andPhysicianAgeIn(List<Integer> values) {
            addCriterion("physician_age in", values, "physicianAge");
            return (Criteria) this;
        }

        public Criteria andPhysicianAgeNotIn(List<Integer> values) {
            addCriterion("physician_age not in", values, "physicianAge");
            return (Criteria) this;
        }

        public Criteria andPhysicianAgeBetween(Integer value1, Integer value2) {
            addCriterion("physician_age between", value1, value2, "physicianAge");
            return (Criteria) this;
        }

        public Criteria andPhysicianAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("physician_age not between", value1, value2, "physicianAge");
            return (Criteria) this;
        }

        public Criteria andPhysicianGenderIsNull() {
            addCriterion("physician_gender is null");
            return (Criteria) this;
        }

        public Criteria andPhysicianGenderIsNotNull() {
            addCriterion("physician_gender is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicianGenderEqualTo(Boolean value) {
            addCriterion("physician_gender =", value, "physicianGender");
            return (Criteria) this;
        }

        public Criteria andPhysicianGenderNotEqualTo(Boolean value) {
            addCriterion("physician_gender <>", value, "physicianGender");
            return (Criteria) this;
        }

        public Criteria andPhysicianGenderGreaterThan(Boolean value) {
            addCriterion("physician_gender >", value, "physicianGender");
            return (Criteria) this;
        }

        public Criteria andPhysicianGenderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("physician_gender >=", value, "physicianGender");
            return (Criteria) this;
        }

        public Criteria andPhysicianGenderLessThan(Boolean value) {
            addCriterion("physician_gender <", value, "physicianGender");
            return (Criteria) this;
        }

        public Criteria andPhysicianGenderLessThanOrEqualTo(Boolean value) {
            addCriterion("physician_gender <=", value, "physicianGender");
            return (Criteria) this;
        }

        public Criteria andPhysicianGenderIn(List<Boolean> values) {
            addCriterion("physician_gender in", values, "physicianGender");
            return (Criteria) this;
        }

        public Criteria andPhysicianGenderNotIn(List<Boolean> values) {
            addCriterion("physician_gender not in", values, "physicianGender");
            return (Criteria) this;
        }

        public Criteria andPhysicianGenderBetween(Boolean value1, Boolean value2) {
            addCriterion("physician_gender between", value1, value2, "physicianGender");
            return (Criteria) this;
        }

        public Criteria andPhysicianGenderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("physician_gender not between", value1, value2, "physicianGender");
            return (Criteria) this;
        }

        public Criteria andPhysicianAvatarIsNull() {
            addCriterion("physician_avatar is null");
            return (Criteria) this;
        }

        public Criteria andPhysicianAvatarIsNotNull() {
            addCriterion("physician_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicianAvatarEqualTo(String value) {
            addCriterion("physician_avatar =", value, "physicianAvatar");
            return (Criteria) this;
        }

        public Criteria andPhysicianAvatarNotEqualTo(String value) {
            addCriterion("physician_avatar <>", value, "physicianAvatar");
            return (Criteria) this;
        }

        public Criteria andPhysicianAvatarGreaterThan(String value) {
            addCriterion("physician_avatar >", value, "physicianAvatar");
            return (Criteria) this;
        }

        public Criteria andPhysicianAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("physician_avatar >=", value, "physicianAvatar");
            return (Criteria) this;
        }

        public Criteria andPhysicianAvatarLessThan(String value) {
            addCriterion("physician_avatar <", value, "physicianAvatar");
            return (Criteria) this;
        }

        public Criteria andPhysicianAvatarLessThanOrEqualTo(String value) {
            addCriterion("physician_avatar <=", value, "physicianAvatar");
            return (Criteria) this;
        }

        public Criteria andPhysicianAvatarLike(String value) {
            addCriterion("physician_avatar like", value, "physicianAvatar");
            return (Criteria) this;
        }

        public Criteria andPhysicianAvatarNotLike(String value) {
            addCriterion("physician_avatar not like", value, "physicianAvatar");
            return (Criteria) this;
        }

        public Criteria andPhysicianAvatarIn(List<String> values) {
            addCriterion("physician_avatar in", values, "physicianAvatar");
            return (Criteria) this;
        }

        public Criteria andPhysicianAvatarNotIn(List<String> values) {
            addCriterion("physician_avatar not in", values, "physicianAvatar");
            return (Criteria) this;
        }

        public Criteria andPhysicianAvatarBetween(String value1, String value2) {
            addCriterion("physician_avatar between", value1, value2, "physicianAvatar");
            return (Criteria) this;
        }

        public Criteria andPhysicianAvatarNotBetween(String value1, String value2) {
            addCriterion("physician_avatar not between", value1, value2, "physicianAvatar");
            return (Criteria) this;
        }

        public Criteria andDepartIdIsNull() {
            addCriterion("depart_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartIdIsNotNull() {
            addCriterion("depart_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartIdEqualTo(Long value) {
            addCriterion("depart_id =", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdNotEqualTo(Long value) {
            addCriterion("depart_id <>", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdGreaterThan(Long value) {
            addCriterion("depart_id >", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdGreaterThanOrEqualTo(Long value) {
            addCriterion("depart_id >=", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdLessThan(Long value) {
            addCriterion("depart_id <", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdLessThanOrEqualTo(Long value) {
            addCriterion("depart_id <=", value, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdIn(List<Long> values) {
            addCriterion("depart_id in", values, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdNotIn(List<Long> values) {
            addCriterion("depart_id not in", values, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdBetween(Long value1, Long value2) {
            addCriterion("depart_id between", value1, value2, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartIdNotBetween(Long value1, Long value2) {
            addCriterion("depart_id not between", value1, value2, "departId");
            return (Criteria) this;
        }

        public Criteria andDepartNameIsNull() {
            addCriterion("depart_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartNameIsNotNull() {
            addCriterion("depart_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartNameEqualTo(String value) {
            addCriterion("depart_name =", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotEqualTo(String value) {
            addCriterion("depart_name <>", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameGreaterThan(String value) {
            addCriterion("depart_name >", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameGreaterThanOrEqualTo(String value) {
            addCriterion("depart_name >=", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLessThan(String value) {
            addCriterion("depart_name <", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLessThanOrEqualTo(String value) {
            addCriterion("depart_name <=", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameLike(String value) {
            addCriterion("depart_name like", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotLike(String value) {
            addCriterion("depart_name not like", value, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameIn(List<String> values) {
            addCriterion("depart_name in", values, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotIn(List<String> values) {
            addCriterion("depart_name not in", values, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameBetween(String value1, String value2) {
            addCriterion("depart_name between", value1, value2, "departName");
            return (Criteria) this;
        }

        public Criteria andDepartNameNotBetween(String value1, String value2) {
            addCriterion("depart_name not between", value1, value2, "departName");
            return (Criteria) this;
        }

        public Criteria andExpertiseIsNull() {
            addCriterion("expertise is null");
            return (Criteria) this;
        }

        public Criteria andExpertiseIsNotNull() {
            addCriterion("expertise is not null");
            return (Criteria) this;
        }

        public Criteria andExpertiseEqualTo(String value) {
            addCriterion("expertise =", value, "expertise");
            return (Criteria) this;
        }

        public Criteria andExpertiseNotEqualTo(String value) {
            addCriterion("expertise <>", value, "expertise");
            return (Criteria) this;
        }

        public Criteria andExpertiseGreaterThan(String value) {
            addCriterion("expertise >", value, "expertise");
            return (Criteria) this;
        }

        public Criteria andExpertiseGreaterThanOrEqualTo(String value) {
            addCriterion("expertise >=", value, "expertise");
            return (Criteria) this;
        }

        public Criteria andExpertiseLessThan(String value) {
            addCriterion("expertise <", value, "expertise");
            return (Criteria) this;
        }

        public Criteria andExpertiseLessThanOrEqualTo(String value) {
            addCriterion("expertise <=", value, "expertise");
            return (Criteria) this;
        }

        public Criteria andExpertiseLike(String value) {
            addCriterion("expertise like", value, "expertise");
            return (Criteria) this;
        }

        public Criteria andExpertiseNotLike(String value) {
            addCriterion("expertise not like", value, "expertise");
            return (Criteria) this;
        }

        public Criteria andExpertiseIn(List<String> values) {
            addCriterion("expertise in", values, "expertise");
            return (Criteria) this;
        }

        public Criteria andExpertiseNotIn(List<String> values) {
            addCriterion("expertise not in", values, "expertise");
            return (Criteria) this;
        }

        public Criteria andExpertiseBetween(String value1, String value2) {
            addCriterion("expertise between", value1, value2, "expertise");
            return (Criteria) this;
        }

        public Criteria andExpertiseNotBetween(String value1, String value2) {
            addCriterion("expertise not between", value1, value2, "expertise");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNull() {
            addCriterion("phone_number is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberEqualTo(String value) {
            addCriterion("phone_number =", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotEqualTo(String value) {
            addCriterion("phone_number <>", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThan(String value) {
            addCriterion("phone_number >", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("phone_number >=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThan(String value) {
            addCriterion("phone_number <", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("phone_number <=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLike(String value) {
            addCriterion("phone_number like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotLike(String value) {
            addCriterion("phone_number not like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIn(List<String> values) {
            addCriterion("phone_number in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotIn(List<String> values) {
            addCriterion("phone_number not in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberBetween(String value1, String value2) {
            addCriterion("phone_number between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("phone_number not between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionIsNull() {
            addCriterion("brief_introduction is null");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionIsNotNull() {
            addCriterion("brief_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionEqualTo(String value) {
            addCriterion("brief_introduction =", value, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionNotEqualTo(String value) {
            addCriterion("brief_introduction <>", value, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionGreaterThan(String value) {
            addCriterion("brief_introduction >", value, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("brief_introduction >=", value, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionLessThan(String value) {
            addCriterion("brief_introduction <", value, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionLessThanOrEqualTo(String value) {
            addCriterion("brief_introduction <=", value, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionLike(String value) {
            addCriterion("brief_introduction like", value, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionNotLike(String value) {
            addCriterion("brief_introduction not like", value, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionIn(List<String> values) {
            addCriterion("brief_introduction in", values, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionNotIn(List<String> values) {
            addCriterion("brief_introduction not in", values, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionBetween(String value1, String value2) {
            addCriterion("brief_introduction between", value1, value2, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andBriefIntroductionNotBetween(String value1, String value2) {
            addCriterion("brief_introduction not between", value1, value2, "briefIntroduction");
            return (Criteria) this;
        }

        public Criteria andPwdIsNull() {
            addCriterion("pwd is null");
            return (Criteria) this;
        }

        public Criteria andPwdIsNotNull() {
            addCriterion("pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPwdEqualTo(String value) {
            addCriterion("pwd =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("pwd <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("pwd >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("pwd >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("pwd <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("pwd <=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLike(String value) {
            addCriterion("pwd like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("pwd not like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdIn(List<String> values) {
            addCriterion("pwd in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("pwd not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("pwd between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("pwd not between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
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