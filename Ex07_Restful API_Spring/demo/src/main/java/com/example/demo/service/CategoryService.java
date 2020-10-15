package com.example.demo.service;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.Category;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    public CategoryDTO insertCategory(CategoryDTO categoryDTO);
    public List<CategoryDTO> getAllCategoriesByName(int pageNumber,String name);
    public CategoryDTO getCategory(int id);
    public CategoryDTO updateCategory(CategoryDTO categoryDTO);
    public boolean deleteCategory(int id);
    public boolean deleteSqlCategory(int id);
}
