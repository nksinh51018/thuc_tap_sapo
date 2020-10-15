package com.example.demo.dao;

import com.example.demo.entity.Category;
import com.example.demo.entity.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Repository
public interface RepositoryDAO extends JpaRepository<Repository,Integer> {
    @Transactional
    @Modifying
    @Query(value = "CALL delete_repository(:id);",nativeQuery = true)
    public void deleteSqlRepository(@Param("id") int id);

    @Transactional
    @Modifying
    public void deleteById(int id);

    @Query(value = "SELECT * FROM repositories WHERE repository_name like :name LIMIT :recordNum OFFSET :pageNumber",nativeQuery = true)
    public List<Repository> findAllRepositoryByName(@Param("pageNumber") int pageNumber, @Param("name") String name, @Param("recordNum") int recordNum);
}
