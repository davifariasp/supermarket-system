package com.example.supermarket_system.services;

import com.example.supermarket_system.dtos.request.PurchaseRequestDto;
import com.example.supermarket_system.dtos.response.PurchaseItemResponse;
import com.example.supermarket_system.dtos.response.PurchaseResponse;
import com.example.supermarket_system.models.Product;
import com.example.supermarket_system.models.Promotion;
import com.example.supermarket_system.models.Purchase;
import com.example.supermarket_system.models.PurchaseItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    WiremockService wiremockService;

    public PurchaseResponse doPurchase(PurchaseRequestDto request){

        List<PurchaseItem> purchaseItems = request.items().stream()
                .map(item -> {
                    Product product = wiremockService.getProductsById(item.id());
                    return new PurchaseItem(product, item.quantity());
                })
                .toList();

        return toResponse(new Purchase(purchaseItems));
    }

    public PurchaseResponse toResponse(Purchase purchase){

        return new PurchaseResponse(
                purchase.getId(),
                purchase.getProducts().stream()
                        .map(purchaseItem -> new PurchaseItemResponse(
                                purchaseItem.getProduct().getId(),
                                purchaseItem.getProduct().getName(),
                                purchaseItem.getQuantity()
                        ))
                        .toList(),
                purchase.getProducts().stream()
                        .map(purchaseItem -> purchaseItem.getPromotions().stream()
                                .map(Promotion::getType)
                                .toList())
                        .flatMap(List::stream)
                        .toList(),
                purchase.getTotal(),
                purchase.getDiscount(),
                purchase.getFinalPrice()
        );
    }
}
