package com.sapo.edu.demo.service.impl;

import com.sapo.edu.demo.common.StringCommon;
import com.sapo.edu.demo.entity.WareHouse;
import com.sapo.edu.demo.repository.ProductRepository;
import com.sapo.edu.demo.repository.WareHouseRepository;
import com.sapo.edu.demo.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class WareHouseServiceImpl implements WareHouseService {

    @Autowired
    private WareHouseRepository wareHouseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Value("${myApplication.recordNumber}")
    private int recordNumber;

    @Value("${myApplication.charNumber}")
    private int charNumber;

    @Override
    public List<WareHouse> getAllWareHouse(int n) {
        List<WareHouse> wareHouses = wareHouseRepository.getAllWarehouses(n * recordNumber,recordNumber);
        return wareHouses;
    }

    @Override
    public List<WareHouse> getAllWareHouseByName(int pageNumber, String name) {
        name = "%"+name+"%";
        List<WareHouse> wareHouses = wareHouseRepository.getAllWarehousesByName(pageNumber*recordNumber,name,recordNumber);
        return wareHouses;
    }

    @Override
    public WareHouse getWareHouseById(int id) {
        return wareHouseRepository.getWarehouseById(id);
    }

    @Override
    public WareHouse insertWareHouse(WareHouse wareHouse) {
        if(wareHouse.getWarehouseCode() == null){
            wareHouse.setWarehouseCode(generateCode());
        }
        else{
            if(checkCode(wareHouse.getWarehouseCode(),0)){
                return null;
            }
        }
        try {
            return wareHouseRepository.save(wareHouse);
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public WareHouse updateWareHouse(WareHouse wareHouse) {
        WareHouse wareHouse1 = updateWarehouse2(wareHouse);
        try {
            return wareHouseRepository.save(wareHouse1);
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean deleteWareHouse(int id) {
        try {
//            WareHouse wareHouse = wareHouseRepository.findById(id).orElse(null);
//            wareHouse.setWarehouseStatus(0);
//            wareHouseRepository.save(wareHouse);
            wareHouseRepository.updateStatusWarehouse(id);
            productRepository.deleteProductByWarehouseId(id);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean checkCode(String code,int id){
        int a = wareHouseRepository.checkCode(code,id);
        if(a ==0){
            return false;
        }
        else{
            return true;
        }
    }

    private String generateCode(){
        String lastCode = wareHouseRepository.getLastCode();
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

    private WareHouse updateWarehouse2(WareHouse wareHouse){
        WareHouse wareHouse1 = wareHouseRepository.findById(wareHouse.getId()).orElse(null);
        String code = wareHouse.getWarehouseCode();
        String location = wareHouse.getLocation();
        wareHouse1.setUpdatedAt(new Date());
        String name =  wareHouse.getWarehouseName();
        if(checkCode(code,wareHouse.getId()) ){
            return null;
        }
        if(code != null){
            wareHouse1.setWarehouseCode(code);
        }
        if(location != null){
            wareHouse1.setLocation(location);
        }
        if(name != null){
            wareHouse1.setWarehouseName(name);
        }
        return wareHouse1;
    }
}
