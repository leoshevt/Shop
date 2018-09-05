package main.java.leonid_shop.domain.product.repository.entity;

import leonid_shop.domain.product.dto.Product;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal price;

    public Product toDto() {
        return Product.builder()
                .id(id)
                .name(name)
                .price(price)
                .build();
    }
}
