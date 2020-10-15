package com.sapo.edu.demo.controller;

import com.sapo.edu.demo.dto.CategoryDTO;
import com.sapo.edu.demo.dto.ProductDTO;
import com.sapo.edu.demo.entity.Product;
import com.sapo.edu.demo.exception.InvalidFieldException;
import com.sapo.edu.demo.service.CategoryService;
import com.sapo.edu.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<ProductDTO> getAllProducts(@Valid @RequestParam int pageNumber){
        return productService.getAllProducts(pageNumber);
    }

    @GetMapping("/products/name")
    public List<ProductDTO> getAllProductsByName(@Valid @RequestParam int pageNumber, @RequestParam String productName){
        return productService.getAllProductsByName(pageNumber,productName);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getProductByID(@PathVariable int id) throws InvalidFieldException {
        HttpStatus status = HttpStatus.OK;
        ProductDTO productDTO = productService.getProductById(id);
        if(productDTO == null){
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(
                productDTO,
                status);
    }

    @PostMapping("/products")
    public ResponseEntity<ProductDTO> insertProduct(@RequestBody ProductDTO productDTO) throws InvalidFieldException {
        ProductDTO productDTO1 = productService.insertProduct(productDTO);
        HttpStatus status = HttpStatus.OK;
        if(productDTO1 == null){
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(
                productDTO1,
                status);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDTO> updateProducts(@RequestBody ProductDTO productDTO,@PathVariable int id) throws InvalidFieldException {
        productDTO.setId(id);
        ProductDTO productDTO1 = productService.updateProduct(productDTO);
        HttpStatus status = HttpStatus.OK;
        if(productDTO1 == null){
            status = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<>(
                productDTO1,
                status);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id){
        try{
           return new ResponseEntity<>(
                   productService.deleteProduct(id),
                   HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
