package com.skillstorm.dtos;

import java.util.Objects;

/**Product DTO Class use the Product Entity data to send and receive 
 * */
public class ProductDto {

	
	private int productId;
	private String productName;
	private double price;
	private int categoryId;

	public ProductDto() {
		
	}

	public ProductDto(int productId, String productName, double price, int categoryId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.categoryId = categoryId;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	@Override
	public int hashCode() {
		return Objects.hash(categoryId, price, productId, productName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDto other = (ProductDto) obj;
		return categoryId == other.categoryId && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& productId == other.productId && Objects.equals(productName, other.productName);
	}


	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", price=" + price
				+ ", categoryId=" + categoryId + "]";
	}



	
	
}
