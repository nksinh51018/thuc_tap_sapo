package com.sapo.edu.demo.service.impl;

import com.sapo.edu.demo.dto.WarehouseDTO;
import com.sapo.edu.demo.entity.Product;
import com.sapo.edu.demo.entity.WareHouse;
import com.sapo.edu.demo.exception.InvalidFieldException;
import com.sapo.edu.demo.repository.ProductRepository;
import com.sapo.edu.demo.repository.WareHouseRepository;
import com.sapo.edu.demo.service.ProductService;
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

    @Autowired
    private ProductService productService;

    @Value("${myApplication.recordNumber}")
    private int recordNumber;

    @Value("${myApplication.charNumber}")
    private int charNumber;

    @Override
    public List<WarehouseDTO> getAllWareHouse(int pageNumber) throws InvalidFieldException {
        List<WarehouseDTO> warehouseDTOs = new ArrayList<>();
        if(pageNumber < 1){
            throw new InvalidFieldException("The page must be greater than 1");
        }
        List<WareHouse> wareHouses = wareHouseRepository.getAllWarehouses(pageNumber * recordNumber,recordNumber);
        wareHouses.forEach(wareHouse -> {
            warehouseDTOs.add(mapWarehouseToWarehouseDTO(wareHouse));
        });
        return warehouseDTOs;
    }

    @Override
    public List<WarehouseDTO> getAllWareHouseByName(int pageNumber, String name) throws InvalidFieldException {
        List<WarehouseDTO> warehouseDTOs = new ArrayList<>();
        if(pageNumber < 1){
            throw new InvalidFieldException("The page must be greater than 1");
        }
        name = "%"+name+"%";
        List<WareHouse> wareHouses = wareHouseRepository.getAllWarehousesByName(pageNumber*recordNumber,name,recordNumber);
        wareHouses.forEach(wareHouse -> {
            warehouseDTOs.add(mapWarehouseToWarehouseDTO(wareHouse));
        });
        return warehouseDTOs;
    }

    @Override
    public WarehouseDTO getWareHouseById(int id) {
        WareHouse wareHouse = wareHouseRepository.getWarehouseById(id);
        if(wareHouse == null){
            return null;
        }
        return mapWarehouseToWarehouseDTO(wareHouse);
    }

    @Override
    public WarehouseDTO insertWareHouse(WarehouseDTO warehouseDTO) throws InvalidFieldException {
        if(warehouseDTO.getWarehouseCode() == null){
            warehouseDTO.setWarehouseCode(generateCode());
        }
        else{
            if(checkCode(warehouseDTO.getWarehouseCode(),0)){
                throw new InvalidFieldException("Warehouse code already exists");
            }
        }
        WareHouse wareHouse = mapWarehouseDTOToWarehouse(warehouseDTO);
        Date now = new Date();
        wareHouse.setCreatedAt(now);
        wareHouse.setUpdatedAt(now);
        try {
            wareHouse = wareHouseRepository.save(wareHouse);
            warehouseDTO = mapWarehouseToWarehouseDTO(wareHouse);
            WarehouseDTO finalWarehouseDTO = warehouseDTO;
            warehouseDTO.getProductDTOs().forEach(productDTO -> {
                productDTO.setWarehouseDTO(finalWarehouseDTO);
                try {
                    productService.insertProduct(productDTO);
                } catch (InvalidFieldException e) {
                    e.printStackTrace();
                }
            });
            return finalWarehouseDTO;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public WarehouseDTO updateWareHouse(WarehouseDTO warehouseDTO) {
        WareHouse wareHouse1 = updateWarehouse2(warehouseDTO);
        try {
            wareHouse1 = wareHouseRepository.save(wareHouse1);
            return mapWarehouseToWarehouseDTO(wareHouse1);
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean deleteWareHouse(int id) {
        try {
            wareHouseRepository.updateStatusWarehouse(id);
            productService.deleteProductByWarehouseId(id);
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

    private WareHouse updateWarehouse2(WarehouseDTO warehouseDTO){
        WareHouse wareHouse1 = wareHouseRepository.findById(warehouseDTO.getId()).orElse(null);
        String code = warehouseDTO.getWarehouseCode();
        String location = warehouseDTO.getLocation();
        wareHouse1.setUpdatedAt(new Date());
        String name =  warehouseDTO.getWarehouseName();
        if(checkCode(code,warehouseDTO.getId()) ){
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

    public WarehouseDTO mapWarehouseToWarehouseDTO(WareHouse wareHouse){
        WarehouseDTO warehouseDTO = new WarehouseDTO();
        warehouseDTO.setCreatedAt(wareHouse.getCreatedAt());
        warehouseDTO.setId(wareHouse.getId());
        warehouseDTO.setLocation(wareHouse.getLocation());
        warehouseDTO.setWarehouseName(wareHouse.getWarehouseName());
        warehouseDTO.setUpdatedAt(wareHouse.getUpdatedAt());
        warehouseDTO.setProductDTOs(productService.getAllProductsByWarehouseId(wareHouse.getId()));
        return warehouseDTO;
    }

    public WareHouse mapWarehouseDTOToWarehouse(WarehouseDTO warehouseDTO){
        WareHouse wareHouse = new WareHouse();
        wareHouse.setCreatedAt(warehouseDTO.getCreatedAt());
        wareHouse.setId(warehouseDTO.getId());
        wareHouse.setLocation(warehouseDTO.getLocation());
        wareHouse.setWarehouseName(warehouseDTO.getWarehouseName());
        wareHouse.setUpdatedAt(warehouseDTO.getUpdatedAt());
        return wareHouse;
    }
}
