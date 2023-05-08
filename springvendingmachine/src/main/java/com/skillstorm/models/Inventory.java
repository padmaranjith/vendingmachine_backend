package com.skillstorm.models;

import java.util.Date;
import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.skillstorm.dtos.InventoryDto;

@Entity
@Table(name = "inventories")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="inventory_id")
	private int inventoryId;
	@Column(name ="machine_id")
	private int machineId;
		@Column(name = "stock_level")
	private int availableCapacity;
	@Column(name ="capacity")
	private int maxCapacity;
	@Column(name ="last_refill_date")
	private Date lastRefillDate;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	public Inventory() {
		
	}



	public Inventory(int inventoryId, int machineId, int availableCapacity, int maxCapacity, Date lastRefillDate,
			Product product) {
		super();
		this.inventoryId = inventoryId;
		this.machineId = machineId;
		this.availableCapacity = availableCapacity;
		this.maxCapacity = maxCapacity;
		this.lastRefillDate = lastRefillDate;
		this.product = product;
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
	
	

	public Date getLastRefillDate() {
		return lastRefillDate;
	}

	public void setLastRefillDate(Date lastRefillDate) {
		this.lastRefillDate = lastRefillDate;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
		Inventory other = (Inventory) obj;
		return inventoryId == other.inventoryId;
	}
	
	/**
	 * Method that convert the entity into Product DTO
	 * */
	public InventoryDto toDto() {
		return new InventoryDto(inventoryId, machineId, availableCapacity, maxCapacity, product.getProductId(),lastRefillDate);
	}

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", machineId=" + machineId + ", availableCapacity="
				+ availableCapacity + ", maxCapacity=" + maxCapacity + ", product=" + product + "]";
	}
	
}