package com.example.demo.mapper;



import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    public static CategoryDTO mapCategoryToCategoryDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryDescription(category.getCategoryDescription());
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setCreatedAt(category.getCreatedAt());
        categoryDTO.setId(category.getId());
        List<ProductDTO> productDTOs = new ArrayList<>();
        category.getProducts().forEach(product -> {
            productDTOs.add(ProductMapper.mapProductToProductDTO(product));
        });
        categoryDTO.setProductDTOs(productDTOs);
        categoryDTO.setUpdatedAt(category.getUpdatedAt());
        return categoryDTO;
    }

    public static Category mapCategoryDTOToCategory(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setCategoryDescription(categoryDTO.getCategoryDescription());
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setCreatedAt(categoryDTO.getCreatedAt());
        category.setUpdatedAt(categoryDTO.getUpdatedAt());
        category.setId(categoryDTO.getId());
        List<Product> products = new ArrayList<>();
        categoryDTO.getProductDTOs().forEach(productDTO -> {
            products.add(ProductMapper.mapProductDTOToProduct(productDTO,category));
        });
        category.setProducts(products);
        category.setUpdatedAt(category.getUpdatedAt());
        return category;
    }

}
