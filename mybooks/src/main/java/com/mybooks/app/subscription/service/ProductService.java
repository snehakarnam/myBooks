package com.mybooks.app.subscription.service;


import com.mybooks.app.subscription.dto.ProductDto;

import java.util.List;

public interface ProductService {
    
    ProductDto createProduct(List<ProductDto> productDTO);

    ProductDto getProductById(String productId);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(String productId, ProductDto productDTO);

    void deleteProduct(String productId);
}
