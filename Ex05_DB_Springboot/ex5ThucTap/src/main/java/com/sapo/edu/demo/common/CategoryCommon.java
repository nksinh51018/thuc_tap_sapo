package com.sapo.edu.demo.common;

import com.sapo.edu.demo.entity.Category;
import com.sapo.edu.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CategoryCommon {

    @Autowired
    private CategoryRepository categoryRepository;

    public void getAllCategories(){
        int n = StringCommon.enterTheNumber("Enter the page: ","Re-enter the page: ");
        System.out.println("----------------Categories---------------");
        List<Category> categories = categoryRepository.getAllCategories(n-1);
        categories.forEach((category) ->{
            System.out.println(category);
        });
        System.out.println("-------------------------------");
    }

    public void getAllCategories(int n){
        //int n = StringCommon.enterTheNumber("Enter the page: ","Re-enter the page: ");
        System.out.println("----------------Categories---------------");
        List<Category> categories = categoryRepository.getAllCategories(n-1);
        categories.forEach((category) ->{
            System.out.println(category);
        });
        System.out.println("-------------------------------");
    }

    public void getAllCategoriesByName(){
        String s = StringCommon.enterTheString("Enter the name: ");
        int n = StringCommon.enterTheNumber("Enter the page: ","Re-enter the page: ");
        System.out.println("----------------Categories---------------");
        List<Category> categories = categoryRepository.getAllCategoriesByName(n-1,s);
        categories.forEach((category) ->{
            System.out.println(category);
        });
        System.out.println("-------------------------------");
    }

    public int getCategoryById(){
        getAllCategories(1);
        int id = StringCommon.enterTheNumber("Enter category id: ","Enter category id: ");
        Category category = categoryRepository.getCategoryById(id);
        if(category == null){
            System.out.println("No category!!!");
            return 0;
        }
        System.out.println(category);
        return id;
    }

    public void insertCategory(){
        getAllCategories(1);
        Category category = new Category();
        category.setCategoryStatus(1);
        category.setCategoryName(StringCommon.enterTheString("Enter the category name: "));
        category.setCategoryDescription(StringCommon.enterTheString("Enter the category description: "));
        //category.setCategoryCode(StringCommon.enterTheString("Enter the category code: "));
        Date now = new Date();
        category.setUpdatedAt(now);
        category.setCreateAt(now);
        category = categoryRepository.insertCategory(category);
        if(category == null){
            System.out.println("Insert category failure");
        }
        else{
            System.out.println(category);
            System.out.println("Insert category complete");
        }
    }

    public void updateCategory(){
        int id = getCategoryById();
        if(id ==0){
            return;
        }
        Category category = new Category();
        category.setId(id);
        category.setCategoryStatus(1);
        category.setCategoryName(StringCommon.enterTheString("Enter the category name: "));
        category.setCategoryDescription(StringCommon.enterTheString("Enter the category description: "));
        //category.setCategoryCode(StringCommon.enterTheString("Enter the category code: "));
        Date now = new Date();
        category.setUpdatedAt(now);

        category = categoryRepository.updateCategory(category);

        if(category == null){
            System.out.println("Update category failure");
        }
        else{
            System.out.println(category);
            System.out.println("Update category complete");
        }
    }

    public void deleteCategory(){
        int id = getCategoryById();
        if(id ==0){
            return;
        }
        boolean check = categoryRepository.deleteCategory(id);
        if(check){
            System.out.println("Delete category complete");
        }
        else{
            System.out.println("Delete category failure");
        }
    }

}
