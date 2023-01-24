package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Stock;
import com.example.demo.repo.StockRepo;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	StockRepo repo;
	
	@Override
	public void addStock(Stock s) {
		repo.save(s);

	}

	@Override
	public List<Stock> getcurrentStock() {
		 
		return repo.getcurrentStock();
	}

}
