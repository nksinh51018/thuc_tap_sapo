package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

public class RepositoryDTO {

    private int id;

    private String repositoryName ;

    private String location;

    private Date createdAt;

    private Date updatedAt;

    private List<ProductDTO> productDTOs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
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
