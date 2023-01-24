package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Purchase;

public interface Purchaseservice {
	
	public Purchase addPurchase(Purchase p);
	public List<Purchase> getallpurchase();
}
