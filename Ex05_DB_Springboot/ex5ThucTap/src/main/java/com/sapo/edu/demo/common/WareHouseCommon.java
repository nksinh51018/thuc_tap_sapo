package com.sapo.edu.demo.common;

import com.sapo.edu.demo.entity.Category;
import com.sapo.edu.demo.entity.WareHouse;
import com.sapo.edu.demo.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Component
public class WareHouseCommon {

   // private Scanner scanner = new Scanner(System.in);

    @Autowired
    private WareHouseService wareHouseService;

    public void getAllWarehouses(){
        int n = StringCommon.enterTheNumber("Enter the page: ","Re-enter the page: ");
        System.out.println("----------------Warehouses---------------");
        List<WareHouse> wareHouses = wareHouseService.getAllWareHouse(n-1);
        wareHouses.forEach((wareHouse) ->{
            System.out.println(wareHouse);
        });
        System.out.println("-------------------------------");
    }

    public void getAllWarehouses(int n){
        System.out.println("----------------Warehouses---------------");
        List<WareHouse> wareHouses = wareHouseService.getAllWareHouse(n-1);
        wareHouses.forEach((wareHouse) ->{
            System.out.println(wareHouse);
        });
        System.out.println("-------------------------------");
    }

    public void getAllWarehousesByName(){
        String s = StringCommon.enterTheString("Enter the name: ");
        int n = StringCommon.enterTheNumber("Enter the page: ","Re-enter the page: ");
        System.out.println("----------------Warehouses---------------");
        List<WareHouse> wareHouses = wareHouseService.getAllWareHouseByName(n-1,s);
        wareHouses.forEach((wareHouse) ->{
            System.out.println(wareHouse);
        });
        System.out.println("-------------------------------");
    }

    public int getWarehouseById(){
        getAllWarehouses(1);
        int id = StringCommon.enterTheNumber("Enter warehouse id: ","Enter warehouse id: ");
        WareHouse wareHouse = wareHouseService.getWareHouseById(id);
        if(wareHouse == null){
            System.out.println("No warehouse!!!");
            return 0;
        }
        System.out.println(wareHouse);
        return id;
    }

    public void insertWarehouse(){
        getAllWarehouses(1);
        WareHouse wareHouse = new WareHouse();
        wareHouse.setWarehouseName(StringCommon.enterTheString("Enter the warehouse name: "));
        wareHouse.setLocation(StringCommon.enterTheString("Enter the warehouse location: "));
        Date now = new Date();
        wareHouse.setCreatedAt(now);
        wareHouse.setUpdatedAt(now);
        wareHouse.setWarehouseStatus(1);
        wareHouse = wareHouseService.insertWareHouse(wareHouse);
        if(wareHouse == null){
            System.out.println("Insert wareHouse failure");
        }
        else{
            System.out.println(wareHouse);
            System.out.println("Insert wareHouse complete");
        }
    }

    public void updateWarehouse(){
        int id = getWarehouseById();
        if(id ==0){
            return;
        }
        WareHouse wareHouse = new WareHouse();
        wareHouse.setId(id);
        wareHouse.setWarehouseStatus(1);
        wareHouse.setUpdatedAt(new Date());
        wareHouse.setLocation(StringCommon.enterTheString("Enter the warehouse location : "));
        wareHouse.setWarehouseName(StringCommon.enterTheString("Enter the warehouse name: "));
        wareHouse = wareHouseService.updateWareHouse(wareHouse);

        if(wareHouse == null){
            System.out.println("Update wareHouse failure");
        }
        else{
            System.out.println(wareHouse);
            System.out.println("Update wareHouse complete");
        }
    }

    public void deleteWarehouse(){
        int id = getWarehouseById();
        if(id ==0){
            return;
        }
        boolean check = wareHouseService.deleteWareHouse(id);
        if(check){
            System.out.println("Delete warehouse complete");
        }
        else{
            System.out.println("Delete warehouse failure");
        }
    }
}
