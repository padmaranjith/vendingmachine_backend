package com.skillstorm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.skillstorm.dtos.InventoryDto;
import com.skillstorm.models.Category;
import com.skillstorm.models.Inventory;
import com.skillstorm.models.Product;
import com.skillstorm.repositories.IInventoryRepository;
import com.skillstorm.repositories.IProductRepository;


/***
 * 
 * @author Padma Ranjith
 * Inventory Service returns CRUD operation related to the Inventory 
 *
 */
@Service
@Transactional
public class InventoryService {

	@Autowired
	private IInventoryRepository inventoryRepository;
	
	@Autowired
	private IProductRepository productRepository;
	
	/**
	 * 
	 * @return List of all Inventories
	 */
	
	public List<Inventory> getAllInventories(){
		return inventoryRepository
				.findAll()
				;
		}
	/**
	 * 
	 * @param inventoryData
	 * @return saved Inventory data
	 */
	public InventoryDto createInventory(InventoryDto inventoryData) {
		Inventory inventory= new Inventory();
		inventory.setMachineId(1);
		inventory.setAvailableCapacity(inventoryData.getAvailableCapacity());
		inventory.setMaxCapacity(inventoryData.getMaxCapacity());
		inventory.setLastRefillDate(inventoryData.getLastRefillDate());
		System.out.println("Adding Inventory Data ..."+inventory.getMaxCapacity()+":"+inventory.getAvailableCapacity()+":"+inventory.getLastRefillDate()+":"+inventoryData.getProductId());
		
		Product product=productRepository
				.findById(inventoryData.getProductId())
				.orElseThrow(()->new RuntimeException("Product not found in the Inventory"));
		
		System.out.println("Adding Inventory after getting product..."+inventoryData.getProductId());
		inventory.setProduct(product);
		
		return inventoryRepository.save(inventory).toDto();
	}
	
	/**
	 * 
	 * @param inventoryData
	 * @return updated inventory data
	 */
	
	public InventoryDto updateInventory(InventoryDto inventoryData) {
		
		Optional<Inventory> optionalUser = inventoryRepository.findById(inventoryData.getInventoryId());

		if (optionalUser.isPresent()) {
		    // Update the properties of the retrieved entity
			Inventory inventory= optionalUser.get();
			inventory.setMachineId(1);
			inventory.setAvailableCapacity(inventoryData.getAvailableCapacity());
			inventory.setMaxCapacity(inventoryData.getMaxCapacity());
			inventory.setLastRefillDate(inventoryData.getLastRefillDate());
			Product product=productRepository
					.findById(inventoryData.getProductId())
					.orElseThrow(()->new RuntimeException("Product not found in the Inventory"));

			inventory.setProduct(product);
		    // Call the save method to update the entity
			
			System.out.println("Inventory values after updating "+inventoryData.getInventoryId());
			return inventoryRepository.save(inventory).toDto();
		}
		else {
			throw new RuntimeException("Inventory not found to update");
		}
	}
	
	/**
	 * 
	 * @param id Delete the inventory by Id
	 */
	public void deleteInventoryById(@PathVariable int id) {
        inventoryRepository.deleteById(id);
}
}
