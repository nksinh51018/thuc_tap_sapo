package com.example.demo.dao;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product,Integer> {
    @Transactional
    @Modifying
    @Query(value = "CALL delete_product(:id);",nativeQuery = true)
    public void deleteSqlRepository(@Param("id") int id);

    @Transactional
    @Modifying
    public void deleteById(int id);

    @Query(value = "SELECT * FROM products WHERE product_name like :name LIMIT :recordNum OFFSET :pageNumber",nativeQuery = true)
    public List<Product> findAllProductByName(@Param("pageNumber") int pageNumber, @Param("name") String name, @Param("recordNum") int recordNum);
}
