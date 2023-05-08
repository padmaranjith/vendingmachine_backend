package com.skillstorm.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.dtos.InventoryDto;
import com.skillstorm.dtos.ProductDto;
import com.skillstorm.models.Inventory;
import com.skillstorm.models.Product;
import com.skillstorm.services.InventoryService;


@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("/inventories")
	public List<Inventory> getAllInventories(){
		return inventoryService.getAllInventories();
	}
	@PostMapping("/addInventory")
	public ResponseEntity<InventoryDto> createInventory(@RequestBody InventoryDto inventoryData) {
		inventoryData.setLastRefillDate(new Date());
		InventoryDto inventory= inventoryService.createInventory(inventoryData);
		return new ResponseEntity<InventoryDto>(inventory, HttpStatus.CREATED);
	}

		
	@PatchMapping("/addInventory/{id}")
	public InventoryDto updateInventory(@PathVariable int id,@RequestBody InventoryDto inventoryData) {
		inventoryData.setInventoryId(id);
		return inventoryService.updateInventory(inventoryData);
	}
	
	@DeleteMapping("/deleteInventory/{id}")
	public void deleteInventoryById(@PathVariable int id) {
		        inventoryService.deleteInventoryById(id);
		}
	
	
}
