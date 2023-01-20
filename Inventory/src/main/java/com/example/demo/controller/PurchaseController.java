package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.entity.Purchase;
import com.example.demo.service.ProductService;
import com.example.demo.service.Purchaseservice;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	Purchaseservice purchaseservice;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/{pid}")
	public void addPurchase(@RequestBody Purchase p,@PathVariable("pid") int pid)
	{
		Product prod = productService.viewById(pid);
		p.setP(prod);
		purchaseservice.addPurchase(p);
	}
}
