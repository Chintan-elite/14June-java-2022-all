package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {
		
	public Product addProduct(Product p);
	public List<Product> viewAllProduct();
	public Product viewById(int id);
	public void updateProduct(Product p, int id);
	public void deleteProduct(int id);
	
}
