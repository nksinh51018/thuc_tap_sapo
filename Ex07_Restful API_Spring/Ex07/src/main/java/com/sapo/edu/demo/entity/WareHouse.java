package com.sapo.edu.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "warehouses")
public class WareHouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 0,max = 10)
    @Column(name = "warehouse_code")
    private String warehouseCode;

    @Size(min = 0,max = 1000)
    @Column(name = "warehouse_name")
    private String warehouseName;

    @Size(min = 0,max = 5000)
    @Column(name = "location")
    private String location;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "warehouse_status")
    private int warehouseStatus;

    @Override
    public String toString() {
        return "WareHouse{" +
                "id=" + id +
                ", warehouseCode='" + warehouseCode + '\'' +
                ", warehouseName='" + warehouseName + '\'' +
                ", location='" + location + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public int getWarehouseStatus() {
        return warehouseStatus;
    }

    public void setWarehouseStatus(int warehouseStatus) {
        this.warehouseStatus = warehouseStatus;
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
}
