package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{
	

	
}

