package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.entity.Product;

public interface ProductService {
		
	public void addProduct(Product p);
	public ArrayList<Product> viewAllProduct();
	public Product viewById(int id);
	public void updateProduct(Product p, int id);
	public void deleteProduct(int id);
	
}
