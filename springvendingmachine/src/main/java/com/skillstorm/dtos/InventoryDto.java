package com.skillstorm.dtos;

import java.util.Objects;

public class InventoryDto {
	private int inventoryId;
	private int machineId;
	private int availableCapacity;
	private int maxCapacity;
	private int productId;
	
	public InventoryDto() {
		
	}
	public InventoryDto(int inventoryId, int machineId, int availableCapacity, int maxCapacity, int productId) {
		super();
		this.inventoryId = inventoryId;
		this.machineId = machineId;
		this.availableCapacity = availableCapacity;
		this.maxCapacity = maxCapacity;
		this.productId = productId;
	}
	public int getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(int inventoryId) {
		this.inventoryId = inventoryId;
	}
	public int getMachineId() {
		return machineId;
	}
	public void setMachineId(int machineId) {
		this.machineId = machineId;
	}
	public int getAvailableCapacity() {
		return availableCapacity;
	}
	public void setAvailableCapacity(int availableCapacity) {
		this.availableCapacity = availableCapacity;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(inventoryId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InventoryDto other = (InventoryDto) obj;
		return inventoryId == other.inventoryId;
	}
	
	
	
	

}
