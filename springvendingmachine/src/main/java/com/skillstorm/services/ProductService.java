package com.skillstorm.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.dtos.ProductDto;
import com.skillstorm.models.Product;
import com.skillstorm.repositories.IProductRepository;


@Service
@Transactional
public class ProductService {
	
	@Autowired
	private IProductRepository productRepository;
	
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
	
	public List<ProductDto> findAllProducts(){
		return productRepository.findAll()
				.stream()
				.map(p->p.toDto())
				.toList();
	}
	
	
	public ProductDto createProduct(ProductDto productData) {
		
		Product product= new Product(productData);
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

}
