package com.example.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckItemsExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table check_items
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table check_items
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table check_items
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_items
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public CheckItemsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_items
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_items
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_items
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_items
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_items
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_items
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_items
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_items
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_items
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table check_items
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table check_items
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
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

        public Criteria andCheckTitleIsNull() {
            addCriterion("check_title is null");
            return (Criteria) this;
        }

        public Criteria andCheckTitleIsNotNull() {
            addCriterion("check_title is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTitleEqualTo(String value) {
            addCriterion("check_title =", value, "checkTitle");
            return (Criteria) this;
        }

        public Criteria andCheckTitleNotEqualTo(String value) {
            addCriterion("check_title <>", value, "checkTitle");
            return (Criteria) this;
        }

        public Criteria andCheckTitleGreaterThan(String value) {
            addCriterion("check_title >", value, "checkTitle");
            return (Criteria) this;
        }

        public Criteria andCheckTitleGreaterThanOrEqualTo(String value) {
            addCriterion("check_title >=", value, "checkTitle");
            return (Criteria) this;
        }

        public Criteria andCheckTitleLessThan(String value) {
            addCriterion("check_title <", value, "checkTitle");
            return (Criteria) this;
        }

        public Criteria andCheckTitleLessThanOrEqualTo(String value) {
            addCriterion("check_title <=", value, "checkTitle");
            return (Criteria) this;
        }

        public Criteria andCheckTitleLike(String value) {
            addCriterion("check_title like", value, "checkTitle");
            return (Criteria) this;
        }

        public Criteria andCheckTitleNotLike(String value) {
            addCriterion("check_title not like", value, "checkTitle");
            return (Criteria) this;
        }

        public Criteria andCheckTitleIn(List<String> values) {
            addCriterion("check_title in", values, "checkTitle");
            return (Criteria) this;
        }

        public Criteria andCheckTitleNotIn(List<String> values) {
            addCriterion("check_title not in", values, "checkTitle");
            return (Criteria) this;
        }

        public Criteria andCheckTitleBetween(String value1, String value2) {
            addCriterion("check_title between", value1, value2, "checkTitle");
            return (Criteria) this;
        }

        public Criteria andCheckTitleNotBetween(String value1, String value2) {
            addCriterion("check_title not between", value1, value2, "checkTitle");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andTabIdIsNull() {
            addCriterion("tab_id is null");
            return (Criteria) this;
        }

        public Criteria andTabIdIsNotNull() {
            addCriterion("tab_id is not null");
            return (Criteria) this;
        }

        public Criteria andTabIdEqualTo(Integer value) {
            addCriterion("tab_id =", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdNotEqualTo(Integer value) {
            addCriterion("tab_id <>", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdGreaterThan(Integer value) {
            addCriterion("tab_id >", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tab_id >=", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdLessThan(Integer value) {
            addCriterion("tab_id <", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdLessThanOrEqualTo(Integer value) {
            addCriterion("tab_id <=", value, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdIn(List<Integer> values) {
            addCriterion("tab_id in", values, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdNotIn(List<Integer> values) {
            addCriterion("tab_id not in", values, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdBetween(Integer value1, Integer value2) {
            addCriterion("tab_id between", value1, value2, "tabId");
            return (Criteria) this;
        }

        public Criteria andTabIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tab_id not between", value1, value2, "tabId");
            return (Criteria) this;
        }

        public Criteria andIsSharedIsNull() {
            addCriterion("is_shared is null");
            return (Criteria) this;
        }

        public Criteria andIsSharedIsNotNull() {
            addCriterion("is_shared is not null");
            return (Criteria) this;
        }

        public Criteria andIsSharedEqualTo(Byte value) {
            addCriterion("is_shared =", value, "isShared");
            return (Criteria) this;
        }

        public Criteria andIsSharedNotEqualTo(Byte value) {
            addCriterion("is_shared <>", value, "isShared");
            return (Criteria) this;
        }

        public Criteria andIsSharedGreaterThan(Byte value) {
            addCriterion("is_shared >", value, "isShared");
            return (Criteria) this;
        }

        public Criteria andIsSharedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_shared >=", value, "isShared");
            return (Criteria) this;
        }

        public Criteria andIsSharedLessThan(Byte value) {
            addCriterion("is_shared <", value, "isShared");
            return (Criteria) this;
        }

        public Criteria andIsSharedLessThanOrEqualTo(Byte value) {
            addCriterion("is_shared <=", value, "isShared");
            return (Criteria) this;
        }

        public Criteria andIsSharedIn(List<Byte> values) {
            addCriterion("is_shared in", values, "isShared");
            return (Criteria) this;
        }

        public Criteria andIsSharedNotIn(List<Byte> values) {
            addCriterion("is_shared not in", values, "isShared");
            return (Criteria) this;
        }

        public Criteria andIsSharedBetween(Byte value1, Byte value2) {
            addCriterion("is_shared between", value1, value2, "isShared");
            return (Criteria) this;
        }

        public Criteria andIsSharedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_shared not between", value1, value2, "isShared");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNull() {
            addCriterion("creator_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNotNull() {
            addCriterion("creator_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdEqualTo(Integer value) {
            addCriterion("creator_id =", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotEqualTo(Integer value) {
            addCriterion("creator_id <>", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThan(Integer value) {
            addCriterion("creator_id >", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("creator_id >=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThan(Integer value) {
            addCriterion("creator_id <", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("creator_id <=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIn(List<Integer> values) {
            addCriterion("creator_id in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotIn(List<Integer> values) {
            addCriterion("creator_id not in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdBetween(Integer value1, Integer value2) {
            addCriterion("creator_id between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("creator_id not between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdIsNull() {
            addCriterion("updater_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdIsNotNull() {
            addCriterion("updater_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdEqualTo(Integer value) {
            addCriterion("updater_id =", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdNotEqualTo(Integer value) {
            addCriterion("updater_id <>", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdGreaterThan(Integer value) {
            addCriterion("updater_id >", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("updater_id >=", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdLessThan(Integer value) {
            addCriterion("updater_id <", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdLessThanOrEqualTo(Integer value) {
            addCriterion("updater_id <=", value, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdIn(List<Integer> values) {
            addCriterion("updater_id in", values, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdNotIn(List<Integer> values) {
            addCriterion("updater_id not in", values, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdBetween(Integer value1, Integer value2) {
            addCriterion("updater_id between", value1, value2, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdaterIdNotBetween(Integer value1, Integer value2) {
            addCriterion("updater_id not between", value1, value2, "updaterId");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andIsCheckedIsNull() {
            addCriterion("is_checked is null");
            return (Criteria) this;
        }

        public Criteria andIsCheckedIsNotNull() {
            addCriterion("is_checked is not null");
            return (Criteria) this;
        }

        public Criteria andIsCheckedEqualTo(Byte value) {
            addCriterion("is_checked =", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedNotEqualTo(Byte value) {
            addCriterion("is_checked <>", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedGreaterThan(Byte value) {
            addCriterion("is_checked >", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_checked >=", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedLessThan(Byte value) {
            addCriterion("is_checked <", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedLessThanOrEqualTo(Byte value) {
            addCriterion("is_checked <=", value, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedIn(List<Byte> values) {
            addCriterion("is_checked in", values, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedNotIn(List<Byte> values) {
            addCriterion("is_checked not in", values, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedBetween(Byte value1, Byte value2) {
            addCriterion("is_checked between", value1, value2, "isChecked");
            return (Criteria) this;
        }

        public Criteria andIsCheckedNotBetween(Byte value1, Byte value2) {
            addCriterion("is_checked not between", value1, value2, "isChecked");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table check_items
     *
     * @mbggenerated do_not_delete_during_merge Thu Oct 22 16:21:40 JST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table check_items
     *
     * @mbggenerated Thu Oct 22 16:21:40 JST 2020
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

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

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value) {
            super();
            this.condition = condition;
            this.value = value;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.betweenValue = true;
        }
    }
}