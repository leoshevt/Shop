package main.java.leonid_shop.domain.product.web;

import leonid_shop.domain.product.dto.Product;
import leonid_shop.domain.product.dto.ProductCreateRequest;
import leonid_shop.domain.product.dto.ProductUpdateRequest;
import leonid_shop.domain.product.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.String.format;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
@Slf4j
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public Product saveProduct(@RequestBody ProductCreateRequest productCreateRequest) {
        return productService.saveProduct(productCreateRequest);
    }
    /*
    Ищем по цене, потому что это учебные проект, он далёк от практического применения
    в голову пришла идея искать цене, так же можно искать по id.
     */
    @PutMapping
    public Product updateProduct(@RequestBody ProductUpdateRequest productUpdateRequest) {
        return productService.updateProduct(productUpdateRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        log.info(format("Deleting product [id=%d]", id));
        productService.deleteProduct(id);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable long id) {
        return productService.getProduct(id);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
