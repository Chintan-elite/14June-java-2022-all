package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Stock;

public interface StockService {
	
	public void addStock(Stock s);
	public List<Stock> getcurrentStock();
}
