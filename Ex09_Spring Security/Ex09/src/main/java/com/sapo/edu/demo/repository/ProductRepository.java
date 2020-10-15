package com.sapo.edu.demo.repository;

import com.sapo.edu.demo.entity.Product;
import com.sapo.edu.demo.exception.InvalidFieldException;

import javax.sql.DataSource;
import java.util.List;

public interface ProductRepository {

    public List<Product> getAllProducts(int pageNumber);
    public List<Product> getAllProductsByName(int pageNumber,String productName);
    public Product getProductById(int id) throws InvalidFieldException;
    public Product insertProduct(Product product) throws InvalidFieldException;
    public Product updateProduct(Product product) throws InvalidFieldException;
    public boolean deleteProduct(int id);
    public boolean deleteProductByWarehouseId(int warehouseId);
    public boolean deleteProductByWCategoryId(int categoryId);
    public List<Product> getAllProductsByCategoryId(int categoryId);
    public List<Product> getAllProductsByWarehouseId(int categoryId);
}
