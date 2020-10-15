package com.sapo.edu.demo.repository;

import com.sapo.edu.demo.entity.Category;

import java.util.List;

public interface CategoryRepository {
    public List<Category> getAllCategoriesByName(int pageNumber,String categoryName);
    public List<Category> getAllCategories(int pageNumber);
    public Category getCategoryById(int id);
    public Category insertCategory(Category category);
    public Category updateCategory(Category category);
    public boolean deleteCategory(int id);
}
