package com.example.demo.repository;

import com.example.demo.entity.Category;

import java.util.List;

public interface CategoryRepository {
    public List<Category> getCategoryByName(String name);
    public List<Category> getCategoryNoSqlInjectionByName(String name);
}
