package com.skillstorm.controllers;

import java.util.List;

import javax.xml.xpath.XPathVariableResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.dtos.ProductDto;
import com.skillstorm.models.Product;
import com.skillstorm.services.ProductService;

/**
 * Product Controller used to handle product requests from the client
 * */


@RestController
@CrossOrigin//(origins = {"http://localhost:3000", "http://localhost:8080"})
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	/**
	 * Method to list all the products
	 * */
	@GetMapping("/products")
	public List<ProductDto> findAllProducts(){
		return productService.findAllProducts();
	}
	
	@PostMapping("/addproduct")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productData) {
		ProductDto product= productService.createProduct(productData);
		return new ResponseEntity<ProductDto>(product, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public void deleteProductById(@PathVariable int id) {
		productService.deleteProductById(id);
	}

}
