package com.example.demo;

import java.util.Date;

public class ProductDTO {

    private int id;
    private int productId;
    private int saleAmount;
    private Date statisticsDate;

    public ProductDTO() {
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", productId=" + productId +
                ", saleAmount=" + saleAmount +
                ", statisticsDate=" + statisticsDate +
                '}';
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(int saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Date getStatisticsDate() {
        return statisticsDate;
    }

    public void setStatisticsDate(Date statisticsDate) {
        this.statisticsDate = statisticsDate;
    }
}
