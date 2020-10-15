package com.example.demo.service.impl;

import com.example.demo.dao.CategoryDAO;
import com.example.demo.dao.ProductDAO;
import com.example.demo.dao.RepositoryDAO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.Repository;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Value("${myApplication.recordNum}")
    private int recordNum;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private RepositoryDAO repositoryDAO;

    @Override
    public ProductDTO insertProduct(ProductDTO productDTO) {
        if(productDTO.getCategoryDTO().getId() == 0|| productDTO.getImageUrl() == null || productDTO.getProductDescription() == null || productDTO.getProductName() == null || productDTO.getRepositoryDTO().getId() == 0){
            return null;
        }
        Product product = ProductMapper.mapProductDTOToProductPub(productDTO);
        product.setId(0);
        Date now = new Date();
        product.setCreatedAt(now);
        product.setUpdatedAt(now);
        try{
            productDAO.save(product);
            return productDTO;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public List<ProductDTO> getAllProductsByName(int pageNumber,String name) {
        List<Product> products = new ArrayList<>();
//        Page<Product> productPage = productDAO.findAll(PageRequest.of(pageNumber-1,recordNum));
//
//        productPage.forEach(product -> {
//            products.add(product);
//        });
        products = productDAO.findAllProductByName((pageNumber -1)*10,"%"+name+"%",recordNum);
        List<ProductDTO> productDTOs = new ArrayList<>();
        products.forEach(product -> productDTOs.add(ProductMapper.mapProductToProductDTO(product)));
        return productDTOs;
    }

    @Override
    public ProductDTO getProductById(int id) {
        Product product =  productDAO.findById(id).orElse(null);
        if(product == null){
            return null;
        }
        return ProductMapper.mapProductToProductDTO(product);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product product = productDAO.findById(productDTO.getId()).orElse(null);
        if(product == null){
            return null;
        }
        product = updateProduct(product,productDTO);
        try{
            productDAO.save(product);
            return productDTO;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    @Transactional
    public boolean deleteProduct(int id) {
        try{
            productDAO.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteSqlProduct(int id) {
        try{
            productDAO.deleteSqlRepository(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    private Product updateProduct(Product product,ProductDTO productDTO){
        Date now = new Date();
        product.setUpdatedAt(now);
        int categoryId = productDTO.getCategoryDTO().getId();
        String imageUrl = productDTO.getImageUrl();
        String productDescription = productDTO.getProductDescription();
        String productName = productDTO.getProductName();
        int repositoryId = productDTO.getRepositoryDTO().getId();
        if(categoryId != 0){
            boolean existsCategory = categoryDAO.existsById(categoryId);
            if(existsCategory) {
                Category category = new Category();
                category.setId(categoryId);
                product.setCategory(category);
            }
            else {
                return null;
            }
        }
        if(repositoryId != 0){
            boolean existsRepository = repositoryDAO.existsById(repositoryId);
            if(existsRepository) {
                Repository repository = new Repository();
                repository.setId(repositoryId);
                product.setRepository(repository);
            }
            else {
                return null;
            }
        }
        if(imageUrl != null){
            product.setImageUrl(imageUrl);
        }
        if(productDescription != null){
            product.setProductDescription(productDescription);
        }
        if(productName != null){
            product.setProductName(productName);
        }
        return product;
    }
}
