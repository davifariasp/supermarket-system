package com.example.supermarket_system.models.promotions;

import com.example.supermarket_system.models.Promotion;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonTypeName("FLAT_PERCENT")
public class FlatPercentPromotion extends Promotion {
    private int amount;
}
