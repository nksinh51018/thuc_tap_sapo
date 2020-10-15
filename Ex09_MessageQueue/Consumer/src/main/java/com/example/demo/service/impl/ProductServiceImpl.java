package com.example.demo.service.impl;

import com.example.demo.ProductDTO;
import com.example.demo.dao.ProductDAO;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    @Autowired
    public ProductServiceImpl(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    @Override
    public boolean insertProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setSaleAmount(productDTO.getSaleAmount());
        product.setStatisticsDate(productDTO.getStatisticsDate());
        product.setProductId(productDTO.getProductId());
        try{
            productDAO.save(product);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
