package com.skillstorm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.dtos.ProductDto;
import com.skillstorm.models.Category;
import com.skillstorm.models.Product;
import com.skillstorm.repositories.ICategoryRepository;
import com.skillstorm.repositories.IProductRepository;


@Service
@Transactional
public class ProductService {
	
	@Autowired
	private IProductRepository productRepository;
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	/**
	 * 3. ModelMapper used to convert entity to DTO
	 */
	@Autowired
	private ModelMapper modelMapper;
//	
//	public List<ProductDto> findAllProducts(){
//		return productRepository.findAll()
//				.stream()
//				.map(this::convertEntityToDto)
//				.collect(Collectors.toList());
//	}
	
//	public List<ProductDto> findAllProducts(){
//		return productRepository.findAll()
//			.stream()
//			.map(p->p.toDto())
//			.toList();
//		}
	
	public List<Product> findAllProducts(){
		return productRepository.findAll();
			
		}
	
	public ProductDto findProductById(int productId) {
		
		return productRepository
				.findById(productId)
				.orElseThrow(()->new RuntimeException("Product with productId " + productId+" not found")).toDto();
	}
	
	public ProductDto createProduct(ProductDto productData) {
		
		Product product= new Product();
		product.setProductName(productData.getProductName());
		product.setPrice(productData.getPrice());
		
		System.out.println("Adding product ..."+product.getProductName()+":"+product.getPrice()+""+productData.getCategoryId());
		
		Category category=categoryRepository
				.findById(productData.getCategoryId())
				.orElseThrow(()->new RuntimeException("Category not found"));
		
		System.out.println("Adding product after getting cate..."+productData.getCategoryId());
		product.setCategory(category);
		System.out.println("product values "+product);
		//return productRepository.save(product).toDto()
		return productRepository.save(product).toDto();
	}
	
	/**
	 * 4. Method to convert Entity to Dto
	 * @param product
	 * @return product DTO
	 */
	private ProductDto convertEntityToDto(Product product) {
	ProductDto productDto=new ProductDto();
	productDto= modelMapper.map(product, ProductDto.class);
		return productDto;
		
	}
	
	public void deleteProductById(int id) {
		productRepository.deleteById(id);
	}


	public ProductDto updateProduct(ProductDto productData) {
		
		Product product= new Product();
		product.setProductId(productData.getProductId());
		product.setProductName(productData.getProductName());
		product.setPrice(productData.getPrice());
		
		System.out.println("Updating product ..."+product.getProductName()+product.getPrice());
		
		Category category=categoryRepository
				.findById(productData.getCategoryId())
				.orElseThrow(()->new RuntimeException("Category not found"));
		
		System.out.println("Updating product after getting cate..."+productData.getCategoryId());
		product.setCategory(category);
		System.out.println("product values "+product);
		//return productRepository.save(product).toDto()
		return productRepository.save(product).toDto();

	}

}
