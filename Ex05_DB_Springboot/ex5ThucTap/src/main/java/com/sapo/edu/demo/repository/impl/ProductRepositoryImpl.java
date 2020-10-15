package com.sapo.edu.demo.repository.impl;

import com.sapo.edu.demo.entity.Product;
import com.sapo.edu.demo.mapper.ProductMapper;
import com.sapo.edu.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private SimpleJdbcCall simpleJdbcCallGetAllByName;
    private SimpleJdbcCall simpleJdbcCallGetAll;
    private SimpleJdbcCall simpleJdbcCallGetByID;
    private SimpleJdbcCall simpleJdbcCallGetLastCode;
    private SimpleJdbcCall simpleJdbcCallCheckCode;
    private SimpleJdbcCall simpleJdbcCallInsert;
    private SimpleJdbcCall simpleJdbcCallUpdate;
    private SimpleJdbcCall simpleJdbcCallDelete;
    private SimpleJdbcCall simpleJdbcCallDeleteByWarehouseId;
    private SimpleJdbcCall simpleJdbcCallDeleteByCategoryId;

    @Value("${myApplication.recordNumber}")
    private int recordNumber;

    @Value("${myApplication.charNumber}")
    private int charNumber;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        ProductMapper productMapper = new ProductMapper();
        this.simpleJdbcCallGetAllByName = new SimpleJdbcCall(dataSource).withProcedureName("read_all_products_by_name")
                .useInParameterNames("pageNumber", "productName", "recordNum")
                .returningResultSet("products", productMapper);
        this.simpleJdbcCallGetAll = new SimpleJdbcCall(dataSource).withProcedureName("read_all_products")
                .useInParameterNames("pageNumber", "recordNum")
                .returningResultSet("products", productMapper);
        this.simpleJdbcCallGetByID = new SimpleJdbcCall(dataSource).withProcedureName("get_product_by_id").useInParameterNames("id")
                .returningResultSet("products", productMapper);
        this.simpleJdbcCallGetLastCode = new SimpleJdbcCall(dataSource).withProcedureName("get_last_code")
                .useInParameterNames("product_code", "id");
        this.simpleJdbcCallCheckCode = new SimpleJdbcCall(dataSource).withProcedureName("check_code");
        this.simpleJdbcCallInsert = new SimpleJdbcCall(dataSource).withProcedureName("insert_product")
                .useInParameterNames("image_url1", "amount1", "category_id1", "created_at1", "price1", "product_code1", "product_description1",
                        "product_status1", "product_name1", "sale_amount1", "updated_at1", "warehouse_id1");
        this.simpleJdbcCallUpdate = new SimpleJdbcCall(dataSource).withProcedureName("update_product")
                .useInParameterNames("image_url1", "amount1", "category_id1", "created_at1", "price1", "product_code1", "product_description1",
                        "product_status1", "product_name1", "sale_amount1", "updated_at1", "warehouse_id1", "id1");
        this.simpleJdbcCallDelete = new SimpleJdbcCall(dataSource).withProcedureName("delete_product")
                .useInParameterNames("id1");
        this.simpleJdbcCallDeleteByWarehouseId = new SimpleJdbcCall(dataSource).withProcedureName("delete_product_by_warehouse_id")
                .useInParameterNames("warehouse_id1");
        this.simpleJdbcCallDeleteByCategoryId = new SimpleJdbcCall(dataSource).withProcedureName("delete_product_by_category_id")
                .useInParameterNames("category_id1");
    }

    @Override
    public List<Product> getAllProducts(int pageNumber) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("pageNumber", pageNumber * recordNumber)
                .addValue("recordNum", recordNumber);
        Map<String, Object> objectMap = simpleJdbcCallGetAll.execute(sqlParameterSource);
        List<Product> products = new ArrayList<>();
        products = (List<Product>) objectMap.get("products");
        return products;
    }

    @Override
    public List<Product> getAllProductsByName(int pageNumber, String productName) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("pageNumber", pageNumber * recordNumber)
                .addValue("productName", productName)
                .addValue("recordNum", recordNumber);
        Map<String, Object> objectMap = simpleJdbcCallGetAllByName.execute(sqlParameterSource);

        List<Product> products = (List<Product>) objectMap.get("products");
        return products;
    }

    @Override
    public Product getProductById(int id) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("id", id);
        Map<String, Object> objectMap = simpleJdbcCallGetByID.execute(sqlParameterSource);

        List<Product> products = (List<Product>) objectMap.get("products");
        if (!products.isEmpty()) {
            return products.get(0);

        } else {
            return null;
        }
    }

    @Override
    public Product insertProduct(Product product) {
        String productCode = product.getProductCode();
        if (productCode == null) {
            product.setProductCode(generateCode());
        } else {
            if (checkCode(productCode, 0)) {
                return null;
            }
        }
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("image_url1", product.getImageUrl())
                .addValue("amount1", product.getAmount())
                .addValue("category_id1", product.getCategoryId())
                .addValue("created_at1", product.getCreatedAt())
                .addValue("price1", product.getPrice())
                .addValue("product_code1", product.getProductCode())
                .addValue("product_description1", product.getProductDescription())
                .addValue("product_status1", product.getProductStatus())
                .addValue("product_name1", product.getProductName())
                .addValue("sale_amount1", product.getSaleAmount())
                .addValue("updated_at1", product.getUpdatedAt())
                .addValue("warehouse_id1", product.getWarehouseId());
        try {
            simpleJdbcCallInsert.execute(sqlParameterSource);
            return product;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Product updateProduct(Product product) {
        Product product1 = updateProduct2(product);
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("image_url1", product1.getImageUrl())
                .addValue("amount1", product1.getAmount())
                .addValue("category_id1", product1.getCategoryId())
                .addValue("created_at1", product1.getCreatedAt())
                .addValue("price1", product1.getPrice())
                .addValue("product_code1", product1.getProductCode())
                .addValue("product_description1", product1.getProductDescription())
                .addValue("product_status1", product1.getProductStatus())
                .addValue("product_name1", product1.getProductName())
                .addValue("sale_amount1", product1.getSaleAmount())
                .addValue("updated_at1", product1.getUpdatedAt())
                .addValue("warehouse_id1", product1.getWarehouseId())
                .addValue("id1", product1.getId());
        try {
            simpleJdbcCallUpdate.execute(sqlParameterSource);
            return product1;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("id1", id);
        ;
        try{
            simpleJdbcCallDelete.execute(sqlParameterSource);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteProductByWarehouseId(int warehouseId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("warehouse_id1", warehouseId);
        ;
        try{
            simpleJdbcCallDeleteByWarehouseId.execute(sqlParameterSource);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteProductByWCategoryId(int categoryId) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("category_id1", categoryId);
        ;
        try{
            simpleJdbcCallDeleteByCategoryId.execute(sqlParameterSource);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private boolean checkCode(String code, int id) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("product_code", code)
                .addValue("id", id);
        ;
        Map<String, Object> objectMap = simpleJdbcCallCheckCode.execute(sqlParameterSource);
        List<LinkedCaseInsensitiveMap> s = (List) objectMap.get("#result-set-1");
        Long a = (Long) s.get(0).get("count(*)");
        if (a == 0) {
            return false;
        } else {
            return true;
        }
    }

    private String generateCode() {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        Map<String, Object> objectMap = simpleJdbcCallGetLastCode.execute(sqlParameterSource);
        List<LinkedCaseInsensitiveMap> s = (List) objectMap.get("#result-set-1");
        String lastCode = (String) s.get(0).get("product_code");
        String[] arr = lastCode.split("_");
        String n = (Integer.parseInt(arr[1]) + 1) + "";
        int a = charNumber - arr[0].length() - n.length();
        String result = arr[0] + "_";
        if (a > 0) {
            for (int i = 0; i < a - 1; i++) {
                result += "0";
            }
        }
        if (a < 0) {
            charNumber++;
            result += "0";
        }
        return result + n;
    }

    private Product updateProduct2(Product product) {
        Product product1 = getProductById(product.getId());
        String code = product.getProductCode();
        int amount = product.getAmount();
        int categoryId = product.getCategoryId();
        String imageUrl = product.getImageUrl();
        BigDecimal price = product.getPrice();
        String description = product.getProductDescription();
        String name = product.getProductName();
        int saleAmount = product.getSaleAmount();
        product1.setUpdatedAt(new Date());
        int warehouseId = product.getWarehouseId();
        if (code != null) {
            if (checkCode(code, product.getId())) {
                return null;
            } else {
                product1.setProductCode(code);
            }
        }
        if (categoryId != 0) {
            product1.setCategoryId(categoryId);
        }
        if (imageUrl != "" && imageUrl != null) {
            product1.setImageUrl(imageUrl);
        }
        if (price != new BigDecimal(0)) {
            product1.setPrice(price);
        }
        if (description != "" && description != null) {
            product1.setProductDescription(description);
        }
        if (name != "" && name != null) {
            product1.setProductName(name);
        }
        if (saleAmount != 0) {
            product1.setSaleAmount(saleAmount);
        }
        if (warehouseId != 0) {
            product1.setWarehouseId(warehouseId);
        }
        return product1;
    }


}
