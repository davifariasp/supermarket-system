package com.example.supermarket_system.controllers;

import com.example.supermarket_system.dtos.request.PurchaseRequestDto;
import com.example.supermarket_system.dtos.response.PurchaseResponse;
import com.example.supermarket_system.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<PurchaseResponse> buy(@RequestBody PurchaseRequestDto request) {
        return ResponseEntity.ok(purchaseService.doPurchase(request));
    }
}
