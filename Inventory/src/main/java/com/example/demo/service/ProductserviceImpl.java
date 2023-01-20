package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repo.Productrepo;

@Service
public class ProductserviceImpl implements ProductService {

	@Autowired
	Productrepo repo;
	
	@Override
	public void addProduct(Product p) {
		 repo.save(p);
		
	}

	@Override
	public ArrayList<Product> viewAllProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product viewById(int id) {
		
		return repo.getById(id);
	}

	@Override
	public void updateProduct(Product p, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
	}

}
