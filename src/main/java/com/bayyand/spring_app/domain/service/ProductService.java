package com.bayyand.spring_app.domain.service;

import com.bayyand.spring_app.common.dto.ProductDto;
import com.bayyand.spring_app.domain.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();
    Product findProductById(Long id);
    Product createProduct(ProductDto productDto);
    Product updateProduct(ProductDto productDto);
    Product updateProductPriceById(Long id, BigDecimal price);
    void disableProductById(Long id);
}
