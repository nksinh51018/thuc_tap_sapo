package com.sapo.edu.demo.mapper;


import com.sapo.edu.demo.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setProductCode(rs.getString("product_code"));
        product.setImageUrl(rs.getString("image_url"));
        product.setProductDescription(rs.getString("product_description"));
        product.setUpdatedAt(rs.getDate("updated_at"));
        product.setCreatedAt(rs.getDate("created_at"));
        product.setAmount(rs.getInt("amount"));
        product.setSaleAmount(rs.getInt("sale_amount"));
        product.setProductName(rs.getString("product_name"));
        product.setCategoryId(rs.getInt("category_id"));
        product.setWarehouseId(rs.getInt("warehouse_id"));
        product.setProductStatus(rs.getInt("product_status"));
        product.setPrice(rs.getBigDecimal("price"));
        return product;
    }
}
