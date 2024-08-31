package com.mybooks.app.subscription.service;


import com.mybooks.app.subscription.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    
    List<ProductDto> createProduct(List<ProductDto> productDTO);

    ProductDto getProductById(String productId);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(String productId, ProductDto productDTO);

    void deleteProduct(String productId);
}
