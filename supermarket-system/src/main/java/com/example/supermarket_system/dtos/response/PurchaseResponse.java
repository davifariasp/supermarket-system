package com.example.supermarket_system.dtos.response;

import java.util.List;
import java.util.UUID;

public record PurchaseResponse(
        UUID id,
        List<PurchaseItemResponse> products,
        List<String> promotions,
        int total,
        int descount,
        int finalPrice
) {
}
