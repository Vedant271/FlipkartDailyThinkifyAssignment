package com.vedantkarale.assignment.flipkart_daily_thinkify_assignment.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class SearchCriteria {
    private List<String> brands;
    private List<String> categories;
    private Integer priceFrom;
    private Integer priceTo;
    private String orderBy;
    private boolean ascending;

    public SearchCriteria(List<String> brands, List<String> categories, Integer priceFrom, Integer priceTo, String orderBy, boolean ascending) {
        this.brands = brands;
        this.categories = categories;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.orderBy = (orderBy != null) ? orderBy : "price";
        this.ascending = ascending;
    }

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Integer getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Integer priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Integer getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Integer priceTo) {
        this.priceTo = priceTo;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public boolean isAscending() {
        return ascending;
    }

    public void setAscending(boolean ascending) {
        this.ascending = ascending;
    }
}

