package com.sapo.edu.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WarehouseDTO {

    private int id;

    @Size(min = 0,max = 10)
    private String warehouseCode;

    @Size(min = 0,max = 1000)
    private String warehouseName;

    @Size(min = 0,max = 5000)
    private String location;

    private Date createdAt;

    private Date updatedAt;

    private List<ProductDTO> productDTOs;

    @Override
    public String toString() {
        return "WarehouseDTO{" +
                "id=" + id +
                ", warehouseCode='" + warehouseCode + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", location='" + location + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", productDTOs=" + productDTOs +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public List<ProductDTO> getProductDTOs() {
        return productDTOs;
    }

    public void setProductDTOs(List<ProductDTO> productDTOs) {
        this.productDTOs = productDTOs;
    }
}
