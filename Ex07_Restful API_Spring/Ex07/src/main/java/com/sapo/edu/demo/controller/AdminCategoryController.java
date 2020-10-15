package com.sapo.edu.demo.controller;

import com.sapo.edu.demo.dto.CategoryDTO;
import com.sapo.edu.demo.exception.InvalidFieldException;
import com.sapo.edu.demo.repository.CategoryRepository;
import com.sapo.edu.demo.repository.ProductRepository;
import com.sapo.edu.demo.service.CategoryService;
import com.sapo.edu.demo.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminCategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategories(@Valid @RequestParam int pageNumber) throws InvalidFieldException {
        return categoryService.getAllCategories(pageNumber);
    }

    @GetMapping("/categories/name")
    public List<CategoryDTO> getAllCategoriesByName(@Valid @RequestParam int pageNumber, @RequestParam String categoryName) throws InvalidFieldException {
        return categoryService.getAllCategoriesByName(pageNumber,categoryName);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Object> getCategoryByID(@PathVariable int id) throws InvalidFieldException {
        HttpStatus status = HttpStatus.OK;
        CategoryDTO categoryDTO = categoryService.getCategoryById(id);
        if(categoryDTO == null){
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(
                categoryDTO,
                status);
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryDTO> insertCategory(@RequestBody CategoryDTO categoryDTO) throws InvalidFieldException {
        CategoryDTO categoryDTO1 = categoryService.insertCategory(categoryDTO);
        HttpStatus status = HttpStatus.OK;
        if(categoryDTO1 == null){
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(
                categoryDTO1,
                status);
    }

    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO,@PathVariable int id) throws InvalidFieldException {
        categoryDTO.setId(id);
        CategoryDTO categoryDTO1 = categoryService.updateCategory(categoryDTO);
        HttpStatus status = HttpStatus.OK;
        if(categoryDTO1 == null){
            status = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<>(
                categoryDTO1,
                status);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity deleteCategory(@PathVariable int id){
        try{
           return new ResponseEntity<>(
                   categoryService.deleteCategory(id),
                   HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//
//    @PostMapping("/repositories")
//    public ResponseEntity<RepositoryDTO> insertRepository(@RequestBody RepositoryDTO repositoryDTO){
//
//        RepositoryDTO repositoryDTO1 = repositoryService.insertRepository(repositoryDTO);
//        HttpStatus status = HttpStatus.OK;
//        if(repositoryDTO1 == null){
//            status = HttpStatus.METHOD_NOT_ALLOWED;
//        }
//        return new ResponseEntity<>(
//                repositoryDTO1,
//                status);
//    }
//
//    @GetMapping("/repositories")
//    public List<RepositoryDTO> getAllRepositories(@RequestParam int pageNumber){
//        return repositoryService.getAllRepositoriesByName(pageNumber,"");
//    }
//
//    @GetMapping("/repositories/{id}")
//    public ResponseEntity<RepositoryDTO> getRepositoryByID(@PathVariable int id){
//        HttpStatus status = HttpStatus.OK;
//        RepositoryDTO repositoryDTO = repositoryService.getRepositoryByID(id);
//        if(repositoryDTO == null){
//            status = HttpStatus.NOT_FOUND;
//        }
//        return new ResponseEntity<>(
//                repositoryDTO,
//                status);
//    }
//
//    @PutMapping("/repositories/{id}")
//    public ResponseEntity<RepositoryDTO> updateRepository(@RequestBody RepositoryDTO repositoryDTO,@PathVariable int id){
//        repositoryDTO.setId(id);
//        RepositoryDTO repositoryDTO1 = repositoryService.updateRepository(repositoryDTO);
//        HttpStatus status = HttpStatus.OK;
//        if(repositoryDTO1 == null){
//            status = HttpStatus.METHOD_NOT_ALLOWED;
//        }
//        return new ResponseEntity<>(
//                repositoryDTO1,
//                status);
//    }
//
//    @DeleteMapping("/repositories/{id}")
//    public ResponseEntity deleteRepository(@PathVariable int id){
//        try{
//            return new ResponseEntity<>(
//                    repositoryService.deleteRepository(id),
//                    HttpStatus.OK);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @DeleteMapping("/repositories/sql/{id}")
//    public ResponseEntity deleteSqlRepository(@PathVariable int id){
//        try{
//            return new ResponseEntity<>(
//                    repositoryService.deleteSqlRepository(id),
//                    HttpStatus.OK);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @PostMapping("/products")
//    public ResponseEntity<ProductDTO> insertProduct(@RequestBody ProductDTO productDTO){
//
//        ProductDTO productDTO1 = productService.insertProduct(productDTO);
//        HttpStatus status = HttpStatus.OK;
//        if(productDTO1 == null){
//            status = HttpStatus.METHOD_NOT_ALLOWED;
//        }
//        return new ResponseEntity<>(
//                productDTO1,
//                status);
//    }
//
//    @GetMapping(value = "/products")
//    public List<ProductDTO> getAllProducts(@RequestParam int pageNumber,@RequestParam String name){
//        return productService.getAllProductsByName(pageNumber,name);
//    }
//
//    @GetMapping("/products/{id}")
//    public ResponseEntity<ProductDTO> getProductByID(@PathVariable int id){
//        HttpStatus status = HttpStatus.OK;
//        ProductDTO productDTO = productService.getProductById(id);
//        if(productDTO == null){
//            status = HttpStatus.NOT_FOUND;
//        }
//        return new ResponseEntity<>(
//                productDTO,
//                status);
//    }
//
//    @PutMapping("/products/{id}")
//    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO,@PathVariable int id){
//        productDTO.setId(id);
//        ProductDTO productDTO1 = productService.updateProduct(productDTO);
//        HttpStatus status = HttpStatus.OK;
//        if(productDTO1 == null){
//            status = HttpStatus.METHOD_NOT_ALLOWED;
//        }
//        return new ResponseEntity<>(
//                productDTO1,
//                status);
//    }
//
//    @DeleteMapping("/products/{id}")
//    public ResponseEntity deleteProduct(@PathVariable int id){
//        try{
//            return new ResponseEntity<>(
//                    productService.deleteProduct(id),
//                    HttpStatus.OK);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @DeleteMapping("/products/sql/{id}")
//    public ResponseEntity deleteSqlProduct(@PathVariable int id){
//        try{
//            return new ResponseEntity<>(
//                    productService.deleteSqlProduct(id),
//                    HttpStatus.OK);
//        }
//        catch (Exception e){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
}
