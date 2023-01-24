package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.entity.Purchase;
import com.example.demo.entity.Stock;
import com.example.demo.service.ProductService;
import com.example.demo.service.Purchaseservice;
import com.example.demo.service.StockService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	Purchaseservice purchaseservice;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	StockService stockService;
	
	@PostMapping("/{pid}")
	public void addPurchase(@RequestBody Purchase p,@PathVariable("pid") int pid)
	{
		Product prod = productService.viewById(pid);
		p.setP(prod);
		Purchase pur =  purchaseservice.addPurchase(p);
		
		
		Stock s = new Stock();
		s.setQty(pur.getQty());
		s.setP(prod);
		s.setFlag("purchase");
		stockService.addStock(s);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Purchase>> getallpurchase()
	{
		return ResponseEntity.ok(purchaseservice.getallpurchase());
	}
}
