package com.sapo.edu.demo.repository;

import com.sapo.edu.demo.entity.Product;

import javax.sql.DataSource;
import java.util.List;

public interface ProductRepository {

    public List<Product> getAllProducts(int pageNumber);
    public List<Product> getAllProductsByName(int pageNumber,String productName);
    public Product getProductById(int id);
    public Product insertProduct(Product product);
    public Product updateProduct(Product product);
    public boolean deleteProduct(int id);
    public boolean deleteProductByWarehouseId(int warehouseId);
    public boolean deleteProductByWCategoryId(int categoryId);
}
