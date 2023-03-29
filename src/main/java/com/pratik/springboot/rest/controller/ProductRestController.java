package com.pratik.springboot.rest.controller;

import com.pratik.springboot.rest.entity.ProductEntity;
import com.pratik.springboot.rest.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@RestController
public class ProductRestController {

    @Autowired
    ProductRepo repo;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);
    @GetMapping("/products")
    //@RequestMapping(value="/products", method=RequestMethod.GET)
    public List<ProductEntity> getProducts() {
        return repo.findAll();
    }

    @GetMapping("/products/{id}")
    public ProductEntity getProductById(@PathVariable("id") int id) {
        LOGGER.info("Finding product by ID" + id);
        return repo.findById(id).get();
    }

    @PostMapping("/products")
    public ProductEntity createProduct(@RequestBody ProductEntity newProduct) {
        return repo.save(newProduct);
    }

    @PutMapping("/products")
    public ProductEntity updateProduct(@RequestBody ProductEntity newProduct) {
        return repo.save(newProduct);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable("id") int id) {
        repo.deleteById(id);
    }

    @PatchMapping("/products")
    public ProductEntity patchProduct(@RequestBody ProductEntity newProduct) {
        return repo.save(newProduct);
    }
}
