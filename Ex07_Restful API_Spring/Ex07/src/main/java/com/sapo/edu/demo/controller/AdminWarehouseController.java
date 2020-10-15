package com.sapo.edu.demo.controller;

import com.sapo.edu.demo.dto.WarehouseDTO;
import com.sapo.edu.demo.exception.InvalidFieldException;
import com.sapo.edu.demo.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AdminWarehouseController {

    @Autowired
    private WareHouseService wareHouseService;

    @GetMapping("/warehouses")
    public List<WarehouseDTO> getAllWarehouses(@Valid @RequestParam int pageNumber) throws InvalidFieldException {
        return wareHouseService.getAllWareHouse(pageNumber);
    }

    @GetMapping("/warehouses/name")
    public List<WarehouseDTO> getAllWarehousesByName(@Valid @RequestParam int pageNumber, @RequestParam String warehouseName) throws InvalidFieldException {
        return wareHouseService.getAllWareHouseByName(pageNumber,warehouseName);
    }

    @GetMapping("/warehouses/{id}")
    public ResponseEntity<Object> getWarehouseByID(@PathVariable int id){
        HttpStatus status = HttpStatus.OK;
        WarehouseDTO warehouseDTO = wareHouseService.getWareHouseById(id);
        if(warehouseDTO == null){
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(
                warehouseDTO,
                status);
    }

    @PostMapping("/warehouses")
    public ResponseEntity<WarehouseDTO> insertWarehouse(@RequestBody WarehouseDTO warehouseDTO) throws InvalidFieldException {
        WarehouseDTO warehouseDTO1 = wareHouseService.insertWareHouse(warehouseDTO);
        HttpStatus status = HttpStatus.OK;
        if(warehouseDTO1 == null){
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(
                warehouseDTO1,
                status);
    }

    @PutMapping("/warehouses/{id}")
    public ResponseEntity<WarehouseDTO> updateWarehouse(@RequestBody WarehouseDTO warehouseDTO,@PathVariable int id){
        warehouseDTO.setId(id);
        WarehouseDTO warehouseDTO1 = wareHouseService.updateWareHouse(warehouseDTO);
        HttpStatus status = HttpStatus.OK;
        if(warehouseDTO1 == null){
            status = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<>(
                warehouseDTO1,
                status);
    }

    @DeleteMapping("/warehouses/{id}")
    public ResponseEntity deleteWarehouse(@PathVariable int id){
        try{
            return new ResponseEntity<>(
                    wareHouseService.deleteWareHouse(id),
                    HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
