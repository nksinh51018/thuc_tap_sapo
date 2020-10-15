package com.example.demo.repository.impl;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> getCategoryByName(String name) {
        String query = "SELECT * FROM categories WHERE category_name = '"+name+"';";
        System.out.println(query);
        CategoryRowMapper categoryRowMapper = new CategoryRowMapper();
        return jdbcTemplate.query(query,categoryRowMapper);
    }

    @Override
    public List<Category> getCategoryNoSqlInjectionByName(String name) {
        String query = "SELECT * FROM categories WHERE category_name = ?;";
        System.out.println(query);
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("name", name);
        CategoryRowMapper categoryRowMapper = new CategoryRowMapper();
        return jdbcTemplate.query(query, new Object[]{name},categoryRowMapper);
    }


    class CategoryRowMapper implements RowMapper<Category> {

        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setCategoryDescription(rs.getString("category_description"));
            category.setCategoryName(rs.getString("category_name"));
            category.setCreatedAt(rs.getDate("created_at"));
            category.setUpdatedAt(rs.getDate("updated_at"));
            return category;
        }

    }
}
