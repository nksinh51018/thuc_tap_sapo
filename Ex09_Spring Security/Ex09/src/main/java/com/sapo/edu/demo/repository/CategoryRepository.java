package com.sapo.edu.demo.repository;

import com.sapo.edu.demo.entity.Category;
import com.sapo.edu.demo.exception.InvalidFieldException;

import java.util.List;

public interface CategoryRepository {
    public List<Category> getAllCategoriesByName(int pageNumber,String categoryName);
    public List<Category> getAllCategories(int pageNumber);
    public Category getCategoryById(int id);
    public int insertCategory(Category category) throws InvalidFieldException;
    public Category updateCategory(Category category) throws InvalidFieldException;
    public boolean deleteCategory(int id) throws InvalidFieldException;
    public int countTotalCatetories();
}
