package com.example.supermarket_system.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Purchase {
    private UUID id;
    private List<PurchaseItem> products;
    private int total;
    private int discount;

    public Purchase(List<PurchaseItem> products) {
        this.id = UUID.randomUUID();
        this.products = products;
        this.total = products.stream().map(PurchaseItem::getPrice).reduce(0, Integer::sum);
        this.discount = 0;
    }
}
