package com.skillstorm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.dtos.InventoryDto;
import com.skillstorm.models.Inventory;
import com.skillstorm.repositories.IInventoryRepository;

@Service
@Transactional
public class InventoryService {

	@Autowired
	private IInventoryRepository inventoryRepository;
	
	public List<Inventory> getAllInventories(){
		return inventoryRepository
				.findAll()
				;
			
		}
}
