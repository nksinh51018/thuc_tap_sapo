package com.sapo.edu.demo.service;

import com.sapo.edu.demo.dto.WarehouseDTO;
import com.sapo.edu.demo.entity.WareHouse;
import com.sapo.edu.demo.exception.InvalidFieldException;

import java.util.List;

public interface WareHouseService {
    public List<WarehouseDTO> getAllWareHouse(int n) throws InvalidFieldException;
    public List<WarehouseDTO> getAllWareHouseByName(int pageNumber,String name) throws InvalidFieldException;
    public WarehouseDTO getWareHouseById(int id);
    public WarehouseDTO insertWareHouse(WarehouseDTO warehouseDTO) throws InvalidFieldException;
    public WarehouseDTO updateWareHouse(WarehouseDTO warehouseDTO);
    public boolean deleteWareHouse(int id);
}
