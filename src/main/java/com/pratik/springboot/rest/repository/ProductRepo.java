package com.pratik.springboot.rest.repository;

import com.pratik.springboot.rest.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepo extends JpaRepository <ProductEntity, Integer> {

}
