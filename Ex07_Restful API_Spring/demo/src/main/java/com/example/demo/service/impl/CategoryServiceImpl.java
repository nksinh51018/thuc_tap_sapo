package com.example.demo.service.impl;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.Category;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Value("${myApplication.recordNum}")
    private int recordNum;

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public CategoryDTO insertCategory(CategoryDTO categoryDTO) {
        if(categoryDTO.getCategoryDescription() == null || categoryDTO.getCategoryName() == null){
            return null;
        }
        Category category = CategoryMapper.mapCategoryDTOToCategory(categoryDTO);
        category.setId(0);
        Date now = new Date();
        category.setCreatedAt(now);
        category.setUpdatedAt(now);
        try{
            categoryDAO.save(category);
            return categoryDTO;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public List<CategoryDTO> getAllCategoriesByName(int pageNumber,String name) {
        List<Category> categories = new ArrayList<>();
//        Page<Category> categoryPage = categoryDAO.findAll(PageRequest.of(pageNumber-1,recordNum));
//
//        categoryPage.forEach(category -> {
//            categories.add(category);
//        });
        categories = categoryDAO.findAllCategoryByName((pageNumber -1)*10,"%"+name+"%",recordNum);
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        categories.forEach(category -> categoryDTOS.add(CategoryMapper.mapCategoryToCategoryDTO(category)));
        return categoryDTOS;
    }

    @Override
    public CategoryDTO getCategory(int id) {
        Category category =  categoryDAO.findById(id).orElse(null);
        if(category == null){
            return null;
        }
        return CategoryMapper.mapCategoryToCategoryDTO(category);
    }


    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        Category category = categoryDAO.findById(categoryDTO.getId()).orElse(null);
        if(category == null){
            return null;
        }
        category = updateCategory(category,categoryDTO);
        try{
            categoryDAO.save(category);
            return categoryDTO;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean deleteCategory(int id) {
        try{
            categoryDAO.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteSqlCategory(int id) {
        try{
            categoryDAO.deleteSqlCategory(id);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private Category updateCategory(Category category,CategoryDTO categoryDTO){
        Date now = new Date();
        category.setUpdatedAt(now);
        String categoryDescription = categoryDTO.getCategoryDescription();
        String categoryName =categoryDTO.getCategoryName();
        if(categoryDescription != null){
            category.setCategoryDescription(categoryDescription);
        }
        if(categoryName != null){
            category.setCategoryName(categoryName);
        }
        return category;
    }

}
