package com.sapo.edu.demo.service.impl;

import com.sapo.edu.demo.dto.CategoryDTO;
import com.sapo.edu.demo.dto.ProductDTO;
import com.sapo.edu.demo.dto.WarehouseDTO;
import com.sapo.edu.demo.entity.Category;
import com.sapo.edu.demo.entity.Product;
import com.sapo.edu.demo.exception.InvalidFieldException;
import com.sapo.edu.demo.repository.ProductRepository;
import com.sapo.edu.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProductsByCategoryId(int categoryId) {
        List<Product> products = productRepository.getAllProductsByCategoryId(categoryId);
        List<ProductDTO> productDTOs = new ArrayList<>();
        products.forEach(product -> {
            productDTOs.add(mapProductToProductDTO(product));
        });
        return productDTOs;
    }

    @Override
    public List<ProductDTO> getAllProductsByWarehouseId(int warehouseId) {
        List<Product> products = productRepository.getAllProductsByWarehouseId(warehouseId);
        List<ProductDTO> productDTOs = new ArrayList<>();
        products.forEach(product -> {
            productDTOs.add(mapProductToProductDTO(product));
        });
        return productDTOs;
    }

    @Override
    public ProductDTO insertProduct(ProductDTO productDTO) throws InvalidFieldException {
        Product product = mapProductDTOToProduct(productDTO);
        product = productRepository.insertProduct(product);
        if(product == null){
            return null;
        }
        return mapProductToProductDTO(product);
    }

    @Override
    public boolean deleteProductByCategoryId(int categoryId) {
        return productRepository.deleteProductByWCategoryId(categoryId);
    }

    @Override
    public boolean deleteProductByWarehouseId(int warehouseId) {
        return productRepository.deleteProductByWarehouseId(warehouseId);
    }

    @Override
    public List<ProductDTO> getAllProductsByName(int pageNumber, String categoryName) {
        List<Product> products = productRepository.getAllProductsByName(pageNumber,categoryName);
        List<ProductDTO> productDTOs = new ArrayList<>();
        products.forEach(product -> {
            productDTOs.add(mapProductToProductDTO(product));
        });
        return productDTOs;
    }

    @Override
    public List<ProductDTO> getAllProducts(int pageNumber) {
        List<Product> products = productRepository.getAllProducts(pageNumber);
        List<ProductDTO> productDTOs = new ArrayList<>();
        products.forEach(product -> {
            productDTOs.add(mapProductToProductDTO(product));
        });
        return productDTOs;
    }

    @Override
    public ProductDTO getProductById(int id) throws InvalidFieldException {
        Product product = productRepository.getProductById(id);
        if(product == null){
            return null;
        }
        return mapProductToProductDTO(product);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) throws InvalidFieldException {
        ProductDTO productDTO1 = getProductById(productDTO.getId());
        Product product = mapProductDTOToProduct(productDTO1);
        product = updateProduct2(product,productDTO);
        product = productRepository.updateProduct(product);
        return mapProductToProductDTO(product);
    }

    @Override
    public boolean deleteProduct(int id) {
        return productRepository.deleteProduct(id);
    }

    private ProductDTO mapProductToProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setAmount(product.getAmount());
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(product.getCategoryId());
        productDTO.setCategoryDTO(categoryDTO);
        productDTO.setCreatedAt(product.getCreatedAt());
        productDTO.setImageUrl(product.getImageUrl());
        productDTO.setId(product.getId());
        productDTO.setProductDescription(product.getProductDescription());
        productDTO.setProductName(product.getProductName());
        WarehouseDTO warehouseDTO = new WarehouseDTO();
        warehouseDTO.setId(product.getWarehouseId());
        productDTO.setWarehouseDTO(warehouseDTO);
        productDTO.setSaleAmount(product.getSaleAmount());
        productDTO.setUpdatedAt(product.getUpdatedAt());
        return productDTO;
    }


    private Product mapProductDTOToProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setAmount(productDTO.getAmount());
        product.setCreatedAt(productDTO.getCreatedAt());
        product.setImageUrl(productDTO.getImageUrl());
        product.setProductDescription(productDTO.getProductDescription());
        product.setProductName(productDTO.getProductName());
        product.setSaleAmount(productDTO.getSaleAmount());
        product.setUpdatedAt(productDTO.getUpdatedAt());
        product.setWarehouseId(productDTO.getWarehouseDTO().getId());
        product.setCategoryId(productDTO.getCategoryDTO().getId());
        return product;
    }

    private Product updateProduct2(Product product,ProductDTO productDTO){
        Date now = new Date();
        product.setUpdatedAt(now);
        int categoryId = productDTO.getCategoryDTO().getId();
        String imageUrl = productDTO.getImageUrl();
        String productDescription = productDTO.getProductDescription();
        String productName = productDTO.getProductName();
        int warehouseId = productDTO.getWarehouseDTO().getId();
        if(categoryId != 0){
            product.setCategoryId(categoryId);
        }
        if(warehouseId != 0){
            product.setWarehouseId(warehouseId);
        }
        if(imageUrl != null){
            product.setImageUrl(imageUrl);
        }
        if(productDescription != null){
            product.setProductDescription(productDescription);
        }
        if(productName != null){
            product.setProductName(productName);
        }
        return product;
    }
}
