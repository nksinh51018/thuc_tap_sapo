package com.sapo.edu.demo.common;

import com.sapo.edu.demo.entity.Category;
import com.sapo.edu.demo.entity.Product;
import com.sapo.edu.demo.entity.WareHouse;
import com.sapo.edu.demo.repository.CategoryRepository;
import com.sapo.edu.demo.repository.ProductRepository;
import com.sapo.edu.demo.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Component
public class ProductCommon {

    @Autowired
    private CategoryCommon categoryCommon;

    @Autowired
    private WareHouseCommon wareHouseCommon;

    @Autowired
    private ProductRepository productRepository;

    public void getAllProducts(){
        int n = StringCommon.enterTheNumber("Enter the page: ","Re-enter the page: ");
        System.out.println("----------------Products---------------");
        List<Product> products = productRepository.getAllProducts(n-1);
        products.forEach((product) ->{
            System.out.println(product);
        });
        System.out.println("-------------------------------");
    }

    public void getAllProducts(int n){
        //int n = StringCommon.enterTheNumber("Enter the page: ","Re-enter the page: ");
        System.out.println("----------------Products---------------");
        List<Product> products = productRepository.getAllProducts(n-1);
        products.forEach((product) ->{
            System.out.println(product);
        });
        System.out.println("-------------------------------");
    }

    public void getAllProductsByName(){
        String s = StringCommon.enterTheString("Enter the name: ");
        int n = StringCommon.enterTheNumber("Enter the page: ","Re-enter the page: ");
        System.out.println("----------------Products---------------");
        List<Product> products = productRepository.getAllProductsByName(n-1,s);
        products.forEach((product) ->{
            System.out.println(product);
        });
        System.out.println("-------------------------------");
    }

    public int getProductById(){
        getAllProducts(1);
        int id = StringCommon.enterTheNumber("Enter product id: ","Enter product id: ");
        Product product = productRepository.getProductById(id);
        if(product == null){
            System.out.println("No product!!!");
            return 0;
        }
        System.out.println(product);
        return id;
    }

    public void insertProduct(){
        getAllProducts(1);
        Product product = new Product();
        categoryCommon.getAllCategories(1);
        product.setCategoryId(StringCommon.enterTheNumber("Enter the category id: ","Re-enter the category id: "));
        wareHouseCommon.getAllWarehouses(1);
        product.setWarehouseId(StringCommon.enterTheNumber("Enter the warehouse id: ","Re-enter the warehouse id: "));
        product.setPrice(new BigDecimal(StringCommon.enterTheNumber("Enter the product price: ","Re-enter the product price: ")));
        product.setProductDescription(StringCommon.enterTheString("Enter the product description: "));
        product.setProductName(StringCommon.enterTheString("Enter the product name: "));
        product.setProductStatus(1);
        product.setSaleAmount(0);
        product.setAmount(StringCommon.enterTheNumber("Enter the product amount: ","Re-enter the product amount: "));
        Date now = new Date();
        product.setCreatedAt(now);
        product.setUpdatedAt(now);
        product.setImageUrl(StringCommon.enterTheString("Enter the image url: "));
        product = productRepository.insertProduct(product);
        if(product == null){
            System.out.println("Insert product failure");
        }
        else{
            System.out.println(product);
            System.out.println("Insert product complete");
        }
    }

    public void updateProduct(){
        int id = getProductById();
        if(id ==0){
            return;
        }
        Product product = new Product();
        product.setId(id);
        categoryCommon.getAllCategories(1);
        product.setCategoryId(StringCommon.enterTheNumber("Enter the category id: ","Re-enter the category id: "));
        wareHouseCommon.getAllWarehouses(1);
        product.setWarehouseId(StringCommon.enterTheNumber("Enter the warehouse id: ","Re-enter the warehouse id: "));
        product.setPrice(new BigDecimal(StringCommon.enterTheNumber("Enter the product price: ","Re-enter the product price: ")));
        product.setProductDescription(StringCommon.enterTheString("Enter the product description: "));
        product.setProductName(StringCommon.enterTheString("Enter the product name: "));
        product.setProductStatus(1);
        product.setSaleAmount(StringCommon.enterTheNumber("Enter the product sale amount: ","Re-enter the product sale amount: "));
        product.setAmount(StringCommon.enterTheNumber("Enter the product amount: ","Re-enter the product amount: "));
        Date now = new Date();
        product.setUpdatedAt(now);
        product.setImageUrl(StringCommon.enterTheString("Enter the image url: "));
        product = productRepository.updateProduct(product);

        if(product == null){
            System.out.println("Update product failure");
        }
        else{
            System.out.println(product);
            System.out.println("Update product complete");
        }
    }

    public void deleteProduct(){
        int id = getProductById();
        if(id ==0){
            return;
        }
        boolean check = productRepository.deleteProduct(id);
        if(check){
            System.out.println("Delete product complete");
        }
        else{
            System.out.println("Delete product failure");
        }
    }

}
