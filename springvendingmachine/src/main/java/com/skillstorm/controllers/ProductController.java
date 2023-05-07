package com.skillstorm.controllers;

import java.util.List;

import javax.xml.xpath.XPathVariableResolver;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.dtos.ProductDto;
import com.skillstorm.models.Product;
import com.skillstorm.services.ProductService;

/**
 * Product Controller used to handle product requests from the client
 * */


@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	/**
	 * Method to list all the products
	 * */
	
	@GetMapping("/products")
	public List<Product> findAllProducts(){
		return productService.findAllProducts();
	}
	
	
	@GetMapping("/{productId}")
	public ProductDto findProductById(@PathVariable int productId) {
		return productService.findProductById(productId);
	}
	
	@PostMapping("/addproduct")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productData) {
		
		ProductDto product= productService.createProduct(productData);
		return new ResponseEntity<ProductDto>(product, HttpStatus.CREATED);
	}
	
	
	@PatchMapping("/addproduct/{id}")
	public ProductDto updateProduct(@PathVariable int id,@RequestBody ProductDto productData) {
		productData.setProductId(id);
		return productService.updateProduct(productData);
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public void deleteProductById(@PathVariable int id) {
		 try {
		        productService.deleteProductById(id);
		    } catch (DataIntegrityViolationException ex) {
		        throw new DataIntegrityViolationException(" Product cannot be deleted due to its availability in the inventory");
		    }
		}

}
