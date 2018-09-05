package main.java.leonid_shop.domain.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import leonid_shop.domain.product.repository.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query(value = "SELECT * FROM product", nativeQuery = true)
    List<ProductEntity> getAllProducts();

    Optional<ProductEntity> findByPrice(BigDecimal price);
}
