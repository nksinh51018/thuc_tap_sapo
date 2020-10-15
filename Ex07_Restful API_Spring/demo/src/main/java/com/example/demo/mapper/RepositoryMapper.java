package com.example.demo.mapper;
import com.example.demo.dto.ProductDTO;
import com.example.demo.dto.RepositoryDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.Repository;

import java.util.ArrayList;
import java.util.List;

public class RepositoryMapper {
    public static RepositoryDTO mapRepositoryToRepositoryDTO(Repository repository){
        RepositoryDTO repositoryDTO = new RepositoryDTO();
        repositoryDTO.setCreatedAt(repository.getCreatedAt());
        repositoryDTO.setId(repository.getId());
        repositoryDTO.setLocation(repository.getLocation());
        List<ProductDTO> productDTOs = new ArrayList<>();
        repository.getProducts().forEach(product -> {
            productDTOs.add(ProductMapper.mapProductToProductDTO(product));
        });
        repositoryDTO.setProductDTOs(productDTOs);
        repositoryDTO.setRepositoryName(repository.getRepositoryName());
        repositoryDTO.setUpdatedAt(repository.getUpdatedAt());
        return repositoryDTO;
    }

    public static Repository mapRepositoryDTOToRepository(RepositoryDTO repositoryDTO){
        Repository repository = new Repository();
        repository.setCreatedAt(repositoryDTO.getCreatedAt());
        repository.setId(repositoryDTO.getId());
        repository.setLocation(repositoryDTO.getLocation());
        List<Product> products = new ArrayList<>();
        repositoryDTO.getProductDTOs().forEach(productDTO -> {
            products.add(ProductMapper.mapProductDTOToProduct(productDTO,repository));
        });
        repository.setProducts(products);
        repository.setRepositoryName(repositoryDTO.getRepositoryName());
        repository.setUpdatedAt(repositoryDTO.getUpdatedAt());
        return repository;
    }

}
