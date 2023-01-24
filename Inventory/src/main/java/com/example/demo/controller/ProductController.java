package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.entity.Stock;
import com.example.demo.service.ProductService;
import com.example.demo.service.StockService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	StockService stockService;
	
	@PostMapping("/")
	public ResponseEntity addProduct(@RequestBody Product p)
	{
		Product prod =  productService.addProduct(p);
		
		Stock s = new Stock();
		s.setQty(prod.getQty());
		s.setP(prod);
		s.setFlag("open");
		stockService.addStock(s);
		
		return new  ResponseEntity(HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Product>> viewProduct()
	{
		
		List<Product> p =  productService.viewAllProduct();
		return ResponseEntity.ok(p);
	}
	
	@GetMapping("/stock")
	public ResponseEntity<List<Stock>> viewcurrentstock()
	{
		
		List<Stock> p = stockService.getcurrentStock();
		return ResponseEntity.ok(p);
	}
	
	
	
}
