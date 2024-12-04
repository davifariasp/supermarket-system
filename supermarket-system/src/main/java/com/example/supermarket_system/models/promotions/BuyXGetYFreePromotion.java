package com.example.supermarket_system.models.promotions;

import com.example.supermarket_system.models.Promotion;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonTypeName("BUY_X_GET_Y_FREE")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BuyXGetYFreePromotion extends Promotion {
    @JsonProperty("required_qty")
    private int requiredQuantity;
    @JsonProperty("free_qty")
    private int freeQuantity;
}
