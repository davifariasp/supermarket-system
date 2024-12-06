package com.example.supermarket_system.models;

import com.example.supermarket_system.models.promotions.BuyXGetYFreePromotion;
import com.example.supermarket_system.models.promotions.FlatPercentPromotion;
import com.example.supermarket_system.models.promotions.QuantityBasedPriceOverridePromotion;
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

        availablePromotions();
    }

    public void availablePromotions(){

        products.forEach(purchaseItem -> {
            List<Promotion> promotions = purchaseItem.getPromotions();
            promotions.forEach(promotion -> {
                applyPromotion(purchaseItem, promotion);
            });
        });

        //a cada x produtos o valor deles passa a ser y
        //        "promotions": [
        //        {
        //            "id": "ibt3EEYczW",
        //                "type": "QTY_BASED_PRICE_OVERRIDE",
        //                "required_qty": 2,
        //                "price": 1799
        //        }
        //      ]

        //cada produto recebe um desconto
        //        "promotions": [
        //        {
        //            "id": "Gm1piPn7Fg",
        //                "type": "FLAT_PERCENT",
        //                "amount": 10
        //        }
        //      ]

        //cada x produtos um passa a ser gratuito
        //        "promotions": [
        //        {
        //            "id": "ZRAwbsO2qM",
        //                "type": "BUY_X_GET_Y_FREE",
        //                "required_qty": 2,
        //                "free_qty": 1
        //        }
        //      ]
    }

    public void applyPromotion(PurchaseItem purchaseItem, Promotion promotion){

        if(promotion instanceof QuantityBasedPriceOverridePromotion qtyPromotion){

            //quantas vezes pode ser aplicada (tem q ser um resultado inteiro)
            int xApply = purchaseItem.getQuantity() / qtyPromotion.getRequiredQuantity();
            int priceApply = qtyPromotion.getPrice();

            int descontoTotal = xApply * qtyPromotion.getPrice();

            setDiscount(descontoTotal);
        }

        if(promotion instanceof FlatPercentPromotion flatPromotion){
            int descontoTotal = 0;
            int totalProdutos = purchaseItem.getQuantity();

            for(int i = 0; i < totalProdutos; i++){
                descontoTotal += purchaseItem.getPriceUnity() * (flatPromotion.getAmount() / 100);
            }

            applyDiscount(descontoTotal);
        }

        if(promotion instanceof BuyXGetYFreePromotion buyPromotion){

            int xApply = purchaseItem.getQuantity() / buyPromotion.getRequiredQuantity();
            int descontoTotal = xApply * purchaseItem.getPriceUnity();

            applyDiscount(descontoTotal);
        }
    }

    public void applyDiscount(int discount){
        this.discount += discount;
    }
}
