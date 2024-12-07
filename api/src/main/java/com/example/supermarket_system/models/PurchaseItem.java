package com.example.supermarket_system.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PurchaseItem {
    private Product product;
    private int quantity;

    public PurchaseItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getPrice() {
        return product.getPrice() * quantity;
    }

    public int getPriceUnity(){
        return product.getPrice();
    }

    public List<Promotion> getPromotions(){
        return product.getPromotions();
    }
}
