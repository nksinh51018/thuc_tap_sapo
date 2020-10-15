package com.sapo.edu.demo.repository.impl;

import com.sapo.edu.demo.entity.Category;
import com.sapo.edu.demo.mapper.CategoryMapper;
import com.sapo.edu.demo.repository.CategoryRepository;
import com.sapo.edu.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private ProductRepository productRepository;

    @Value("${myApplication.recordNumber}")
    private int recordNumber;

    @Value("${myApplication.charNumber}")
    private int charNumber;

    public List<Category> getAllCategoriesByName(int pageNumber,String categoryName){
        List<Category> categories = new ArrayList<>();
        categoryName = "%"+categoryName+"%";
        String query = "SELECT * FROM categories \n" +
                "where category_name like :categoryName \n" +
                "and category_status = 1 \n" +
                "order by category_name\n" +
                "limit :recordNumber \n" +
                "offset :pageNumber ;";
//        CategoryRowMapper categoryRowMapper = new CategoryRowMapper();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("categoryName",categoryName)
                .addValue("recordNumber",recordNumber)
                .addValue("pageNumber",pageNumber*recordNumber);
        categories = jdbcTemplate.query(query,sqlParameterSource,new CategoryMapper());
        //System.out.println(pageNumber+" - "+ categoryName);
        return categories;
    }

    @Override
    public List<Category> getAllCategories(int pageNumber) {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM categories \n" +
                "where category_status = 1 \n" +
                "limit :recordNumber \n" +
                "offset :pageNumber ;";
//        CategoryRowMapper categoryRowMapper = new CategoryRowMapper();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("recordNumber",recordNumber)
                .addValue("pageNumber",pageNumber*recordNumber);
        categories = jdbcTemplate.query(query,sqlParameterSource,new CategoryMapper());
        //System.out.println(pageNumber+" - "+ categoryName);
        return categories;
    }

    @Override
    public Category getCategoryById(int id) {
        String query = "SELECT * FROM categories \n" +
                "where category_status = 1 \n" +
                "and id= :id ;";
//        CategoryRowMapper categoryRowMapper = new CategoryRowMapper();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("id",id);
        List<Category> categories = jdbcTemplate.query(query,sqlParameterSource,new CategoryMapper());
        if(categories.size() > 0){
            return categories.get(0);
        }
        return null;
    }

    @Override
    public Category insertCategory(Category category) {
        if(category.getCategoryCode() == null){
            category.setCategoryCode(generateCode());
        }
        else{
            if(checkCode(category.getCategoryCode(),0)){
                return null;
            }
        }
        String query = "INSERT INTO categories " +
                "(category_code, category_name, category_description, created_at, updated_at, category_status)" +
                " VALUES ( :categoryCode , :categoryName , :categoryDescription , :createdAt , :updatedAt , :categoryStatus);";
//        CategoryRowMapper categoryRowMapper = new CategoryRowMapper();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("categoryCode",category.getCategoryCode())
                .addValue("categoryName",category.getCategoryName())
                .addValue("categoryDescription",category.getCategoryDescription())
                .addValue("createdAt",category.getCreateAt())
                .addValue("updatedAt",category.getUpdatedAt())
                .addValue("categoryStatus",category.getCategoryStatus());

        try {
            jdbcTemplate.update(query,sqlParameterSource);
        }
        catch (Exception e){
            return null;
        }
        return category;
    }

    @Override
    public Category updateCategory(Category category) {
        if(checkCode(category.getCategoryCode(),category.getId())){
            return null;
        }
        String query = "UPDATE categories SET ";
        if(category.getCategoryCode() != null){
            query +=  "category_code = :categoryCode ,";
        }
        query += "category_name = :categoryName ," +
                "category_description = :categoryDescription ," +
                "updated_at = :updatedAt " +
                "where id = :id ;";
//        CategoryRowMapper categoryRowMapper = new CategoryRowMapper();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("categoryCode",category.getCategoryCode())
                .addValue("categoryName",category.getCategoryName())
                .addValue("categoryDescription",category.getCategoryDescription())
                .addValue("updatedAt",category.getUpdatedAt())
                .addValue("id",category.getId());

        try {
            jdbcTemplate.update(query,sqlParameterSource);
            return getCategoryById(category.getId());
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteCategory(int id) {
        String query = "UPDATE categories SET " +
                "category_status = 0 " +
                "where id = :id ;";
//        CategoryRowMapper categoryRowMapper = new CategoryRowMapper();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("id",id);

        try {
            jdbcTemplate.update(query,sqlParameterSource);
            productRepository.deleteProductByWCategoryId(id);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean checkCode(String code,int id){
        String query = "SELECT count(*) FROM categories \n" +
                "where category_code = :code \n" +
                "and id != :id ;";
//        CategoryRowMapper categoryRowMapper = new CategoryRowMapper();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("code",code)
                .addValue("id",id);;
        int a = jdbcTemplate.queryForObject(query,sqlParameterSource,Integer.class);
        if(a ==0){
            return false;
        }
        else{
            return true;
        }
    }

    private String generateCode(){
        String query = "SELECT category_code FROM categories\n" +
                "order by category_code desc\n" +
                "limit 1;";
//        CategoryRowMapper categoryRowMapper = new CategoryRowMapper();
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        String lastCode = jdbcTemplate.queryForObject(query,sqlParameterSource,String.class);
        String[] arr = lastCode.split("_");
        String n = (Integer.parseInt(arr[1]) + 1)+"";
        int a = charNumber - arr[0].length() -n.length();
        String result = arr[0]+"_";
        if(a > 0){
            for (int i=0;i<a-1;i++){
                result+="0";
            }
        }
        if(a<0){
            charNumber++;
            result+="0";
        }
        return result + n;
    }
//
//    private String getCodeById(int id){
//        String query = "SELECT category_code FROM categories \n" +
//                "WHERE id= :id ; ";
////        CategoryRowMapper categoryRowMapper = new CategoryRowMapper();
//        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
//                .addValue("id",id);
//
//        try {
//            return jdbcTemplate.queryForObject(query,sqlParameterSource,String.class);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return null;
//        }
//    }

}
