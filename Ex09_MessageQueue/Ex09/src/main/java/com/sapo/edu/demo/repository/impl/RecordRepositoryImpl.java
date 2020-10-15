package com.sapo.edu.demo.repository.impl;

import com.sapo.edu.demo.entity.Product;
import com.sapo.edu.demo.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class RecordRepositoryImpl implements RecordRepository {

    private SimpleJdbcCall simpleJdbcCallCount;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcCallCount = new SimpleJdbcCall(dataSource).withProcedureName("count_product_in_warehouse")
                .useInParameterNames("warehouse_code");
    }

    @Override
    public void count(String warehouseCode) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("warehouse_code", warehouseCode);
        try {
            simpleJdbcCallCount.execute(sqlParameterSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
