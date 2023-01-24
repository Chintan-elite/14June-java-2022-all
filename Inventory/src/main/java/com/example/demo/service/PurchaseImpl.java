package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Purchase;
import com.example.demo.repo.PurchaseRepo;

@Service
public class PurchaseImpl implements Purchaseservice{

	@Autowired
	PurchaseRepo repo;
	
	@Override
	public Purchase addPurchase(Purchase p) {
		
		return  repo.save(p);
	}

	@Override
	public List<Purchase> getallpurchase() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
