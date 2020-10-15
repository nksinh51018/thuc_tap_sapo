package com.sapo.edu.demo.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.sapo.edu.demo.entity.WareHouse;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {
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

    private BigDecimal price;

    private CategoryDTO categoryDTO;

    private WarehouseDTO warehouseDTO;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", amount=" + amount +
                ", saleAmount=" + saleAmount +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", price=" + price +
                ", categoryDTO=" + categoryDTO +
                ", warehouseDTO=" + warehouseDTO +
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public WarehouseDTO getWarehouseDTO() {
        return warehouseDTO;
    }

    public void setWarehouseDTO(WarehouseDTO warehouseDTO) {
        this.warehouseDTO = warehouseDTO;
    }
}
