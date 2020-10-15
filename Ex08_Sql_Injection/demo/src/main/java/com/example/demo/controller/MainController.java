package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(path = "/{name}")
    public List<Category> getCategoryByName(@PathVariable String name){
        return categoryRepository.getCategoryByName(name);
    }

    @GetMapping(path = "/noSql/{name}")
    public List<Category> getCategoryNoSqlInjectionById(@PathVariable String name){
        return categoryRepository.getCategoryNoSqlInjectionByName(name);
    }

}
