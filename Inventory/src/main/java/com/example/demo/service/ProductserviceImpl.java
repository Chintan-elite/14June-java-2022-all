package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repo.Productrepo;

@Service
public class ProductserviceImpl implements ProductService {

	@Autowired
	Productrepo repo;
	
	@Override
	public Product addProduct(Product p) {
		 return repo.save(p);
		
	}

	@Override
	public List<Product> viewAllProduct() {
		
		return repo.findAll();
	}

	@Override
	public Product viewById(int id) {
		
		return repo.getById(id);
	}

	@Override
	public void updateProduct(Product p, int id) {
		
		p.setpId(id);
		repo.save(p);
	}

	@Override
	public void deleteProduct(int id) {
		repo.deleteById(id);
		
	}

}
