package main.java.leonid_shop.domain.product.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class Product {
    private final Long id;
    private final String name;
    private final BigDecimal price;
}
