package com.example.supermarket_system.models.promotions;

import com.example.supermarket_system.models.Promotion;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeName("QTY_BASED_PRICE_OVERRIDE")
public class QuantityBasedPriceOverridePromotion extends Promotion {
    @JsonProperty("required_qty")
    private int requiredQuantity;

    private int price;
}
