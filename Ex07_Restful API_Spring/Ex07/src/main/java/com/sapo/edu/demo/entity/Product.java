package com.sapo.edu.demo.entity;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

public class Product {

    private int id;

    @Size(min = 0,max = 10)
    private String productCode;

    @Size(min = 0,max = 100)
    private String productName;

    @Size(min = 0,max = 5000)
    private String productDescription;

    @Size(min = 0,max = 1000)
    private String imageUrl;

    private int amount;

    private int saleAmount;

    private Date createdAt;

    private Date updatedAt;

    private int categoryId;

    private int warehouseId;

    private int productStatus;

    private BigDecimal price;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", amount=" + amount +
                ", saleAmount=" + saleAmount +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", categoryId=" + categoryId +
                ", warehouseId=" + warehouseId +
                ", productStatus=" + productStatus +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(int saleAmount) {
        this.saleAmount = saleAmount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
