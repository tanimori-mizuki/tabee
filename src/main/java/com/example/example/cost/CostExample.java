package com.example.example.cost;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CostExample {    
	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CostExample() {
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

        public Criteria andShioriIdIsNull() {
            addCriterion("shiori_id is null");
            return (Criteria) this;
        }

        public Criteria andShioriIdIsNotNull() {
            addCriterion("shiori_id is not null");
            return (Criteria) this;
        }

        public Criteria andShioriIdEqualTo(Integer value) {
            addCriterion("shiori_id =", value, "shioriId");
            return (Criteria) this;
        }

        public Criteria andShioriIdNotEqualTo(Integer value) {
            addCriterion("shiori_id <>", value, "shioriId");
            return (Criteria) this;
        }

        public Criteria andShioriIdGreaterThan(Integer value) {
            addCriterion("shiori_id >", value, "shioriId");
            return (Criteria) this;
        }

        public Criteria andShioriIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("shiori_id >=", value, "shioriId");
            return (Criteria) this;
        }

        public Criteria andShioriIdLessThan(Integer value) {
            addCriterion("shiori_id <", value, "shioriId");
            return (Criteria) this;
        }

        public Criteria andShioriIdLessThanOrEqualTo(Integer value) {
            addCriterion("shiori_id <=", value, "shioriId");
            return (Criteria) this;
        }

        public Criteria andShioriIdIn(List<Integer> values) {
            addCriterion("shiori_id in", values, "shioriId");
            return (Criteria) this;
        }

        public Criteria andShioriIdNotIn(List<Integer> values) {
            addCriterion("shiori_id not in", values, "shioriId");
            return (Criteria) this;
        }

        public Criteria andShioriIdBetween(Integer value1, Integer value2) {
            addCriterion("shiori_id between", value1, value2, "shioriId");
            return (Criteria) this;
        }

        public Criteria andShioriIdNotBetween(Integer value1, Integer value2) {
            addCriterion("shiori_id not between", value1, value2, "shioriId");
            return (Criteria) this;
        }

        public Criteria andCostCategoryIdIsNull() {
            addCriterion("cost_category_id is null");
            return (Criteria) this;
        }

        public Criteria andCostCategoryIdIsNotNull() {
            addCriterion("cost_category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCostCategoryIdEqualTo(Integer value) {
            addCriterion("cost_category_id =", value, "costCategoryId");
            return (Criteria) this;
        }

        public Criteria andCostCategoryIdNotEqualTo(Integer value) {
            addCriterion("cost_category_id <>", value, "costCategoryId");
            return (Criteria) this;
        }

        public Criteria andCostCategoryIdGreaterThan(Integer value) {
            addCriterion("cost_category_id >", value, "costCategoryId");
            return (Criteria) this;
        }

        public Criteria andCostCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cost_category_id >=", value, "costCategoryId");
            return (Criteria) this;
        }

        public Criteria andCostCategoryIdLessThan(Integer value) {
            addCriterion("cost_category_id <", value, "costCategoryId");
            return (Criteria) this;
        }

        public Criteria andCostCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("cost_category_id <=", value, "costCategoryId");
            return (Criteria) this;
        }

        public Criteria andCostCategoryIdIn(List<Integer> values) {
            addCriterion("cost_category_id in", values, "costCategoryId");
            return (Criteria) this;
        }

        public Criteria andCostCategoryIdNotIn(List<Integer> values) {
            addCriterion("cost_category_id not in", values, "costCategoryId");
            return (Criteria) this;
        }

        public Criteria andCostCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("cost_category_id between", value1, value2, "costCategoryId");
            return (Criteria) this;
        }

        public Criteria andCostCategoryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cost_category_id not between", value1, value2, "costCategoryId");
            return (Criteria) this;
        }

        public Criteria andCostIsNull() {
            addCriterion("cost is null");
            return (Criteria) this;
        }

        public Criteria andCostIsNotNull() {
            addCriterion("cost is not null");
            return (Criteria) this;
        }

        public Criteria andCostEqualTo(Integer value) {
            addCriterion("cost =", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotEqualTo(Integer value) {
            addCriterion("cost <>", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThan(Integer value) {
            addCriterion("cost >", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostGreaterThanOrEqualTo(Integer value) {
            addCriterion("cost >=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThan(Integer value) {
            addCriterion("cost <", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostLessThanOrEqualTo(Integer value) {
            addCriterion("cost <=", value, "cost");
            return (Criteria) this;
        }

        public Criteria andCostIn(List<Integer> values) {
            addCriterion("cost in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotIn(List<Integer> values) {
            addCriterion("cost not in", values, "cost");
            return (Criteria) this;
        }

        public Criteria andCostBetween(Integer value1, Integer value2) {
            addCriterion("cost between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andCostNotBetween(Integer value1, Integer value2) {
            addCriterion("cost not between", value1, value2, "cost");
            return (Criteria) this;
        }

        public Criteria andIsIndividualIsNull() {
            addCriterion("is_individual is null");
            return (Criteria) this;
        }

        public Criteria andIsIndividualIsNotNull() {
            addCriterion("is_individual is not null");
            return (Criteria) this;
        }

        public Criteria andIsIndividualEqualTo(Byte value) {
            addCriterion("is_individual =", value, "isIndividual");
            return (Criteria) this;
        }

        public Criteria andIsIndividualNotEqualTo(Byte value) {
            addCriterion("is_individual <>", value, "isIndividual");
            return (Criteria) this;
        }

        public Criteria andIsIndividualGreaterThan(Byte value) {
            addCriterion("is_individual >", value, "isIndividual");
            return (Criteria) this;
        }

        public Criteria andIsIndividualGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_individual >=", value, "isIndividual");
            return (Criteria) this;
        }

        public Criteria andIsIndividualLessThan(Byte value) {
            addCriterion("is_individual <", value, "isIndividual");
            return (Criteria) this;
        }

        public Criteria andIsIndividualLessThanOrEqualTo(Byte value) {
            addCriterion("is_individual <=", value, "isIndividual");
            return (Criteria) this;
        }

        public Criteria andIsIndividualIn(List<Byte> values) {
            addCriterion("is_individual in", values, "isIndividual");
            return (Criteria) this;
        }

        public Criteria andIsIndividualNotIn(List<Byte> values) {
            addCriterion("is_individual not in", values, "isIndividual");
            return (Criteria) this;
        }

        public Criteria andIsIndividualBetween(Byte value1, Byte value2) {
            addCriterion("is_individual between", value1, value2, "isIndividual");
            return (Criteria) this;
        }

        public Criteria andIsIndividualNotBetween(Byte value1, Byte value2) {
            addCriterion("is_individual not between", value1, value2, "isIndividual");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andPayerIdIsNull() {
            addCriterion("payer_id is null");
            return (Criteria) this;
        }

        public Criteria andPayerIdIsNotNull() {
            addCriterion("payer_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayerIdEqualTo(Integer value) {
            addCriterion("payer_id =", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdNotEqualTo(Integer value) {
            addCriterion("payer_id <>", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdGreaterThan(Integer value) {
            addCriterion("payer_id >", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("payer_id >=", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdLessThan(Integer value) {
            addCriterion("payer_id <", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdLessThanOrEqualTo(Integer value) {
            addCriterion("payer_id <=", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdIn(List<Integer> values) {
            addCriterion("payer_id in", values, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdNotIn(List<Integer> values) {
            addCriterion("payer_id not in", values, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdBetween(Integer value1, Integer value2) {
            addCriterion("payer_id between", value1, value2, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("payer_id not between", value1, value2, "payerId");
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