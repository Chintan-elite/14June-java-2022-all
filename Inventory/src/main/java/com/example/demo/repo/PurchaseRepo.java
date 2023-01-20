package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Purchase;

public interface PurchaseRepo extends JpaRepository<Purchase, Integer> {
	
}
