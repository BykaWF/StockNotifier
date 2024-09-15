package com.yaroslavcode.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Stock {
    private String company;
    private BigDecimal price;
    private BigDecimal changedValue;
    private BigDecimal changeDifference;
    private BigDecimal openPrice;
    private BigDecimal highPrice;
    private BigDecimal lowPrice;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getChangedValue() {
        return changedValue;
    }

    public void setChangedValue(BigDecimal changedValue) {
        this.changedValue = changedValue;
    }

    public BigDecimal getChangeDifference() {
        return changeDifference;
    }

    public void setChangeDifference(BigDecimal changeDifference) {
        this.changeDifference = changeDifference;
    }

    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(BigDecimal openPrice) {
        this.openPrice = openPrice;
    }

    public BigDecimal getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(BigDecimal highPrice) {
        this.highPrice = highPrice;
    }

    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(company, stock.company) && Objects.equals(price, stock.price) && Objects.equals(changedValue, stock.changedValue) && Objects.equals(changeDifference, stock.changeDifference) && Objects.equals(openPrice, stock.openPrice) && Objects.equals(highPrice, stock.highPrice) && Objects.equals(lowPrice, stock.lowPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, price, changedValue, changeDifference, openPrice, highPrice, lowPrice);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "company='" + company + '\'' +
                ", price=" + price +
                ", changedValue=" + changedValue +
                ", changeDifference=" + changeDifference +
                ", openPrice=" + openPrice +
                ", highPrice=" + highPrice +
                ", lowPrice=" + lowPrice +
                '}';
    }
}
