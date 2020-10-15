package com.sapo.edu.demo.service;

import com.sapo.edu.demo.dto.CategoryDTO;
import com.sapo.edu.demo.dto.ProductDTO;
import com.sapo.edu.demo.exception.InvalidFieldException;

import java.util.List;

public interface ProductService {

    public List<ProductDTO> getAllProductsByCategoryId(int categoryId);
    public List<ProductDTO> getAllProductsByWarehouseId(int warehouseId);
    public ProductDTO insertProduct(ProductDTO productDTO) throws InvalidFieldException;
    public boolean deleteProductByCategoryId(int categoryId);
    public boolean deleteProductByWarehouseId(int warehouseId);
    public List<ProductDTO> getAllProductsByName(int pageNumber, String categoryName);
    public List<ProductDTO> getAllProducts(int pageNumber);
    public ProductDTO getProductById(int id) throws InvalidFieldException;
    public ProductDTO updateProduct(ProductDTO productDTO) throws InvalidFieldException;
    public boolean deleteProduct(int id);
}
