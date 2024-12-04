package com.example.supermarket_system.services;

import com.example.supermarket_system.dtos.request.PurchaseRequestDto;
import com.example.supermarket_system.models.Product;
import com.example.supermarket_system.models.Purchase;
import com.example.supermarket_system.models.PurchaseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class PurchaseService {

    @Autowired
    WiremockService wiremockService;

    public void getProducts(PurchaseRequestDto request){

        List<PurchaseItem> purchaseItems = request.items().stream()
                .map(item -> {
                    Product product = wiremockService.getProductsById(item.id());
                    return new PurchaseItem(product, item.quantity());
                })
                .toList();

        Purchase purchase = new Purchase(purchaseItems);
    }
}
