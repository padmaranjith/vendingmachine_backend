package com.skillstorm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.dtos.CategoryDto;
import com.skillstorm.repositories.ICategoryRepository;

@Service
@Transactional
public class CategoryService {
	
	@Autowired
	private ICategoryRepository categoryRepository;

	public List<CategoryDto> findAllCategories(){
		return categoryRepository.findAll()
				.stream()
				.map(c->c.toCategoryDto())
				.toList();
	}
}
