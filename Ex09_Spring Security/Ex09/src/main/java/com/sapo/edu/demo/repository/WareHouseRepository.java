package com.sapo.edu.demo.repository;

import com.sapo.edu.demo.entity.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WareHouseRepository extends JpaRepository<WareHouse,Integer> {

    @Query(nativeQuery = true,value = "SELECT * FROM warehouses \n" +
            "where warehouse_name like :name \n" +
            "and warehouse_status = 1 \n" +
            "order by warehouse_name \n" +
            "limit :recordNumber \n" +
            "offset :pageNumber ;")
    public List<WareHouse> getAllWarehousesByName(@Param("pageNumber") int pageNumber,@Param("name")  String name,@Param("recordNumber")  int recordNumber);

    @Query(nativeQuery = true,value = "SELECT * FROM warehouses \n" +
            "where warehouse_status = 1 \n" +
            "limit :recordNumber \n" +
            "offset :pageNumber ;")
    public List<WareHouse> getAllWarehouses(@Param("pageNumber") int pageNumber,@Param("recordNumber")  int recordNumber);

    @Query(nativeQuery = true,value = "SELECT * FROM warehouses \n" +
            "where warehouse_status = 1 \n" +
            "and id = :id ;")
    public WareHouse getWarehouseById(@Param("id") int id);

    @Query(nativeQuery = true,value = "SELECT warehouse_code FROM warehouses \n" +
            "order by warehouse_code desc \n" +
            "limit 1;")
    public String getLastCode();

    @Query(nativeQuery = true,value = "SELECT count(*) FROM warehouses \n" +
            "where warehouse_code = :code \n" +
            "and id != :id ;")
    public int checkCode(@Param("code") String code,@Param("id") int id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(nativeQuery = true,value = "UPDATE warehouses SET warehouse_status = 0 WHERE (id = :id );")
    public void updateStatusWarehouse(@Param("id") int id);

}
