package com.pratik.springboot.rest;

import com.pratik.springboot.rest.entity.ProductEntity;
import com.pratik.springboot.rest.repository.ProductRepo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApplicationTests {

	@Autowired
	private ProductRepo repository;

	@Test
	void contextLoads() {
		System.out.println("Print1: " + repository.findById(1).get());
		System.out.println("Print2: " + repository.findById(2).get());
	}

	@BeforeEach
	void setup() {
		ProductEntity entity = new ProductEntity();
		//entity.setId(1);
		entity.setDescription("First Product");
		entity.setName("Product Name 1");
		entity.setPrice(100);

		//System.out.println("entity ; " + entity);
		repository.save(entity);
		entity.setId(2);
		entity.setDescription("Second Product");
		entity.setName("Product Name 2");
		entity.setPrice(200);
		repository.save(entity);
	}
}
