package com.example.supermarket_system.controllers;

import com.example.supermarket_system.services.WiremockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    WiremockService wiremockService;

    @GetMapping
    public ResponseEntity getProducts(){
        return ResponseEntity.ok(wiremockService.getProducts());
    }

    @GetMapping("/{productId}")
    public ResponseEntity getProductsById(@PathVariable String productId){

        return ResponseEntity.ok(wiremockService.getProductsById(productId));
    }
}
