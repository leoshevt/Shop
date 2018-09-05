package main.java.leonid_shop.domain.product.service;

import leonid_shop.domain.product.dto.Product;
import leonid_shop.domain.product.dto.ProductCreateRequest;
import leonid_shop.domain.product.dto.ProductUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import leonid_shop.domain.product.repository.ProductRepository;
import leonid_shop.domain.product.repository.entity.ProductEntity;
import leonid_shop.infra.exception.NotFoundException;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

@Service
@Slf4j
@AllArgsConstructor
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public Product saveProduct(ProductCreateRequest productCreateRequest) {
        final String name = productCreateRequest.getName();
        final BigDecimal price = productCreateRequest.getPrice();
        log.info(format("Saving product [name=%s, price=%s]", name, price));
        final ProductEntity entity = ProductEntity.builder()
                .name(name)
                .price(price)
                .build();
        return productRepository.save(entity).toDto();
    }
    /*
    Ищем по цене, потому что это учебные проект, он далёк от практического применения
    в голову пришла идея искать цене, так же можно искать по id.
     */
    public Product updateProduct(ProductUpdateRequest productUpdateRequest) {
        final ProductEntity productEntity = productRepository.findByPrice(productUpdateRequest.getPrice())
                .orElseThrow(() -> new NotFoundException(ProductEntity.class));
        productEntity.setPrice(productUpdateRequest.getNewPrice());
        log.info("Price was changed");
        return productEntity.toDto();
    }


    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    public Product getProduct(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ProductEntity.class))
                .toDto();
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts().stream()
                .map(ProductEntity::toDto)
                .collect(toList());
    }
}
