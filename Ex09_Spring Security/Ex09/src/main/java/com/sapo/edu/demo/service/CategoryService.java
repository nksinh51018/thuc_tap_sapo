package com.sapo.edu.demo.service;

import com.sapo.edu.demo.dto.CategoryDTO;
import com.sapo.edu.demo.exception.InvalidFieldException;

import java.util.List;

public interface CategoryService {

    public List<CategoryDTO> getAllCategoriesByName(int pageNumber, String categoryName) throws InvalidFieldException;
    public List<CategoryDTO> getAllCategories(int pageNumber) throws InvalidFieldException;
    public CategoryDTO getCategoryById(int id) throws InvalidFieldException;
    public CategoryDTO insertCategory(CategoryDTO categoryDTO) throws InvalidFieldException;
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) throws InvalidFieldException;
    public boolean deleteCategory(int id) throws InvalidFieldException;
    public int countTotalCatetories();
}
