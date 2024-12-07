package com.example.supermarket_system.dtos.response;

public record PurchaseItemResponse (
    String id,
    String name,
    int quantity
    ){}
