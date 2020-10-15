package com.sapo.edu.demo.service;

import com.sapo.edu.demo.entity.WareHouse;

import java.util.List;

public interface WareHouseService {
    public List<WareHouse> getAllWareHouse(int n);
    public List<WareHouse> getAllWareHouseByName(int pageNumber,String name);
    public WareHouse getWareHouseById(int id);
    public WareHouse insertWareHouse(WareHouse wareHouse);
    public WareHouse updateWareHouse(WareHouse wareHouse);
    public boolean deleteWareHouse(int id);
}
