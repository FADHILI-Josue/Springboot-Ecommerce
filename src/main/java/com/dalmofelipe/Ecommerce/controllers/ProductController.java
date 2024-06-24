package com.dalmofelipe.Ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dalmofelipe.Ecommerce.models.Product;
import com.dalmofelipe.Ecommerce.records.ProductInput;
import com.dalmofelipe.Ecommerce.services.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<Product> create(@RequestBody ProductInput productInput) {
        return ResponseEntity.ok(productService.create(productInput));
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> listAll() {
        return ResponseEntity.ok(productService.listAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getOne(@PathVariable(name = "id") Integer productId) {
        return ResponseEntity.ok(productService.getOne(productId));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> update(@Validated @RequestBody ProductInput productInput, 
            @PathVariable(name = "id") Integer productId) {
        return ResponseEntity.ok(productService.update(productInput, productId));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer productId) {
        productService.delete(productId);
        return ResponseEntity.noContent().build();
    }

}
