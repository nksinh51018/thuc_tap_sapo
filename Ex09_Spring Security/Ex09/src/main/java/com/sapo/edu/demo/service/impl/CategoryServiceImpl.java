package com.sapo.edu.demo.service.impl;

import com.sapo.edu.demo.dto.CategoryDTO;
import com.sapo.edu.demo.dto.ProductDTO;
import com.sapo.edu.demo.entity.Category;
import com.sapo.edu.demo.entity.Product;
import com.sapo.edu.demo.exception.InvalidFieldException;
import com.sapo.edu.demo.repository.CategoryRepository;
import com.sapo.edu.demo.repository.ProductRepository;
import com.sapo.edu.demo.service.CategoryService;
import com.sapo.edu.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductService productService;

    @Override
    public List<CategoryDTO> getAllCategoriesByName(int pageNumber, String categoryName) throws InvalidFieldException {
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        if(pageNumber < 1){
            throw new InvalidFieldException("The page must be greater than 1");
        }
        List<Category> categories = categoryRepository.getAllCategoriesByName(pageNumber - 1,categoryName);
        categories.forEach(category -> {
            categoryDTOs.add(mapCategoryToCategoryDTO(category));
        });
        return categoryDTOs;
    }

    @Override
    public List<CategoryDTO> getAllCategories(int pageNumber) throws InvalidFieldException {
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        if(pageNumber < 1){
            throw new InvalidFieldException("The page must be greater than 1");
        }
        List<Category> categories = categoryRepository.getAllCategories(pageNumber - 1);
        categories.forEach(category -> {
            categoryDTOs.add(mapCategoryToCategoryDTO(category));
        });
        return categoryDTOs;
    }

    @Override
    public CategoryDTO getCategoryById(int id) throws InvalidFieldException {
        Category category = categoryRepository.getCategoryById(id);
        if(category == null){
            throw new InvalidFieldException("Not found category with id = "+id);
        }
        return mapCategoryToCategoryDTO(category);
    }

    @Override
    public CategoryDTO insertCategory(CategoryDTO categoryDTO) throws InvalidFieldException {
        Category category = mapCategoryDTOToCategory(categoryDTO);
        int key = categoryRepository.insertCategory(category);
        if(key == 0){
            return null;
        }
        categoryDTO.setId(key);
        categoryDTO.getProductDTOs().forEach(productDTO -> {
            productDTO.setCategoryDTO(categoryDTO);
            try {
                productService.insertProduct(productDTO);
            } catch (InvalidFieldException e) {
                e.printStackTrace();
            }
        });
        CategoryDTO categoryDTO1 = mapCategoryToCategoryDTO(category);
        categoryDTO1.setId(key);
        return categoryDTO1;
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) throws InvalidFieldException {
        Category category = mapCategoryDTOToCategory(categoryDTO);
        category = categoryRepository.updateCategory(category);
        if(category == null){
            return null;
        }
        return mapCategoryToCategoryDTO(category);
    }

    @Override
    public boolean deleteCategory(int id) throws InvalidFieldException {
        productService.deleteProductByCategoryId(id);
        return categoryRepository.deleteCategory(id);
    }

    @Override
    public int countTotalCatetories() {
        return categoryRepository.countTotalCatetories();
    }

    private CategoryDTO mapCategoryToCategoryDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryDescription(category.getCategoryDescription());
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setCreateAt(category.getCreateAt());
        categoryDTO.setId(category.getId());
        categoryDTO.setProductDTOs(productService.getAllProductsByCategoryId(category.getId()));
        categoryDTO.setUpdatedAt(category.getUpdatedAt());
        categoryDTO.setCategoryCode(category.getCategoryCode());
        return categoryDTO;
    }

    private Category mapCategoryDTOToCategory(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setCategoryDescription(categoryDTO.getCategoryDescription());
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setCreateAt(categoryDTO.getCreateAt());
        category.setUpdatedAt(categoryDTO.getUpdatedAt());
        category.setId(categoryDTO.getId());
        category.setUpdatedAt(category.getUpdatedAt());
        category.setCategoryCode(categoryDTO.getCategoryCode());
        return category;
    }
}
