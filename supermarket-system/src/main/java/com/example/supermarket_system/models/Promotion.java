package com.example.supermarket_system.models;

import com.example.supermarket_system.models.promotions.BuyXGetYFreePromotion;
import com.example.supermarket_system.models.promotions.FlatPercentPromotion;
import com.example.supermarket_system.models.promotions.QuantityBasedPriceOverridePromotion;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = BuyXGetYFreePromotion.class, name = "BUY_X_GET_Y_FREE"),
        @JsonSubTypes.Type(value = FlatPercentPromotion.class, name = "FLAT_PERCENT"),
        @JsonSubTypes.Type(value = QuantityBasedPriceOverridePromotion.class, name = "QTY_BASED_PRICE_OVERRIDE")
})
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public abstract class Promotion {
    private String id;
    private String type;
}
