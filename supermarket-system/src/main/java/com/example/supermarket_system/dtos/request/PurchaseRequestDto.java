package com.example.supermarket_system.dtos.request;

import java.util.List;

public record PurchaseRequestDto(
        List<ItemBuy> items
) {
    public record ItemBuy(
            String id,
            int quantity
    ){}
}


