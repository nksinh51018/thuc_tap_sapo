package com.sapo.edu.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDTO {

    @Min(0)
    private int id;

    @Size(min = 0,max = 10)
    private String categoryCode;

    @Size(min = 0,max = 10)
    private String categoryName;

    @Size(min = 0,max = 5000)
    private String categoryDescription;

    private Date createAt;

    private Date updatedAt;

    private List<ProductDTO> productDTOs;

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", categoryCode='" + categoryCode + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                ", createAt=" + createAt +
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

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
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
