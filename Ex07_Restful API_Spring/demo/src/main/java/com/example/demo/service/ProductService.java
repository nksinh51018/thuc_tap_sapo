package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
    public ProductDTO insertProduct(ProductDTO productDTO);
    public List<ProductDTO> getAllProductsByName(int pageNumber,String name);
    public ProductDTO getProductById(int id);
    public ProductDTO updateProduct(ProductDTO productDTO);
    public boolean deleteProduct(int id);
    public boolean deleteSqlProduct(int id);
}
