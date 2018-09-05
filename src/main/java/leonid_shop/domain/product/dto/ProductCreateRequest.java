package main.java.leonid_shop.domain.product.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ProductCreateRequest {
    private final String name;
    private final BigDecimal price;

    @JsonCreator
    public ProductCreateRequest(@JsonProperty("name") String name,
                                @JsonProperty("price") BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
