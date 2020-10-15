package com.example.demo.dto;

import org.springframework.lang.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class CategoryDTO {
    @NonNull
    @Min(0)
    private int id;

    private String categoryName;

    private String categoryDescription;

    private Date createdAt;

    private Date updatedAt;

    private List<ProductDTO> productDTOs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
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
