package com.example.demo.mapper;


import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.RepositoryDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.entity.Repository;

public class ProductMapper {

    public static ProductDTO mapProductToProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setAmount(product.getAmount());
        productDTO.setCategoryDTO(mapCategoryToCategoryDTO(product.getCategory()));
        productDTO.setCreatedAt(product.getCreatedAt());
        productDTO.setImageUrl(product.getImageUrl());
        productDTO.setId(product.getId());
        productDTO.setProductDescription(product.getProductDescription());
        productDTO.setProductName(product.getProductName());
        productDTO.setRepositoryDTO(mapRepositoryToRepositoryDTO(product.getRepository()));
        productDTO.setSaleAmount(product.getSaleAmount());
        productDTO.setUpdatedAt(product.getUpdatedAt());
        return productDTO;
    }

    public static Product mapProductDTOToProduct(ProductDTO productDTO,Category category){
        Product product = mapProductDTOToProduct(productDTO);
        product.setCategory(category);
        Repository repository = new Repository();
        repository.setId(productDTO.getRepositoryDTO().getId());
        product.setRepository(repository);
        return product;
    }

    public static Product mapProductDTOToProduct(ProductDTO productDTO,Repository repository){
        Product product = mapProductDTOToProduct(productDTO);
        Category category = new Category();
        category.setId(productDTO.getCategoryDTO().getId());
        product.setCategory(category);
        product.setRepository(repository);
        return product;
    }

    public static Product mapProductDTOToProductPub(ProductDTO productDTO){
        Product product = mapProductDTOToProduct(productDTO);
        Category category = new Category();
        category.setId(productDTO.getCategoryDTO().getId());
        product.setCategory(category);
        Repository repository = new Repository();
        repository.setId(productDTO.getRepositoryDTO().getId());
        product.setRepository(repository);
        return product;
    }

    private static CategoryDTO mapCategoryToCategoryDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryDescription(category.getCategoryDescription());
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setCreatedAt(category.getCreatedAt());
        categoryDTO.setId(category.getId());
        categoryDTO.setUpdatedAt(category.getUpdatedAt());
        return  categoryDTO;
    }

    private static RepositoryDTO mapRepositoryToRepositoryDTO(Repository repository){
        RepositoryDTO repositoryDTO = new RepositoryDTO();
        repositoryDTO.setCreatedAt(repository.getCreatedAt());
        repositoryDTO.setId(repository.getId());
        repositoryDTO.setLocation(repository.getLocation());
        repositoryDTO.setRepositoryName(repository.getRepositoryName());
        repositoryDTO.setUpdatedAt(repository.getUpdatedAt());
        return repositoryDTO;
    }

    private static Product mapProductDTOToProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setAmount(productDTO.getAmount());
        product.setCreatedAt(productDTO.getCreatedAt());
        product.setImageUrl(productDTO.getImageUrl());
        product.setProductDescription(productDTO.getProductDescription());
        product.setProductName(productDTO.getProductName());
        product.setSaleAmount(productDTO.getSaleAmount());
        product.setUpdatedAt(productDTO.getUpdatedAt());
        return product;
    }

}
