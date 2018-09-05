package main.java.leonid_shop.domain.product.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductUpdateRequest {
    private final BigDecimal price;
    private final BigDecimal newPrice;

    @JsonCreator
    public ProductUpdateRequest(@JsonProperty("price") BigDecimal price,
                                @JsonProperty("newPrice") BigDecimal newPrice) {
        this.price = price;
        this.newPrice = newPrice;
    }
}
