package com.skillstorm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.skillstorm.models.Inventory;

@Repository
public interface IInventoryRepository extends JpaRepository<Inventory, Integer> {

}
