package com.skillstorm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.dtos.CategoryDto;
import com.skillstorm.services.CategoryService;

@RestController
@RequestMapping()
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public List<CategoryDto> findAllCategories(){
		return categoryService.findAllCategories();
	}
	

}
