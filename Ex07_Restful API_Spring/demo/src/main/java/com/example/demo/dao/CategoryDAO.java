package com.example.demo.dao;

import com.example.demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CategoryDAO extends JpaRepository<Category,Integer> {
    @Transactional
    @Modifying
    @Query(value = "CALL delete_category(:id);",nativeQuery = true)
    public void deleteSqlCategory(@Param("id") int id);

    @Transactional
    @Modifying
    public void deleteById(int id);

    @Query(value = "SELECT * FROM categories WHERE category_name like :name LIMIT :recordNum OFFSET :pageNumber",nativeQuery = true)
    public List<Category> findAllCategoryByName(@Param("pageNumber") int pageNumber, @Param("name") String name,@Param("recordNum") int recordNum);
}
