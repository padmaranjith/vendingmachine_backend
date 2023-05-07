package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillstorm.models.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
