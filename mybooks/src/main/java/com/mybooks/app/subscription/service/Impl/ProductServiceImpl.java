package com.mybooks.app.subscription.service.Impl;



import com.mybooks.app.subscription.dto.ProductDto;
import com.mybooks.app.subscription.entity.ProductEntity;
import com.mybooks.app.subscription.service.DBGateway.ProductDBGateway;
import com.mybooks.app.subscription.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductDBGateway productDBGateway;

    public ProductServiceImpl(ProductDBGateway productDBGateway) {
        this.productDBGateway = productDBGateway;
    }

//    @Override
//    public List<ProductEntity> createProduct(List<ProductDto> productDTO) {
//        return productDBGateway.createProduct(productDTO);
//    }

    @Override
    public ProductDto getProductById(String productId) {
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return List.of();
    }

    @Override
    public ProductDto updateProduct(String productId, ProductDto productDTO) {
        return null;
    }

    @Override
    public void deleteProduct(String productId) {

    }
}
