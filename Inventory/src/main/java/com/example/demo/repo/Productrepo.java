package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;

public interface Productrepo extends JpaRepository<Product, Integer>
{

}
