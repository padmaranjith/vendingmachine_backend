package com.skillstorm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.dtos.InventoryDto;
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
	
	
}
