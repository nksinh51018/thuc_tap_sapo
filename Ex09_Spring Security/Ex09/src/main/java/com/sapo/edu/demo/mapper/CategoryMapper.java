package com.sapo.edu.demo.mapper;


import com.sapo.edu.demo.entity.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();
        category.setId(rs.getInt("id"));
        category.setCategoryCode(rs.getString("category_code"));
        category.setCategoryDescription(rs.getString("category_description"));
        category.setCategoryName(rs.getString("category_name"));
        category.setCreateAt(rs.getDate("created_at"));
        category.setUpdatedAt(rs.getDate("updated_at"));
        category.setCategoryStatus(rs.getInt("category_status"));
        return category;
    }
}
