package com.mybooks.app.subscription.repository.DBGatewayImpl;



import com.mybooks.app.subscription.dto.ProductDto;
import com.mybooks.app.subscription.entity.ProductEntity;
import com.mybooks.app.subscription.repository.ProductRepository;
import com.mybooks.app.subscription.service.DBGateway.ProductDBGateway;

import java.util.List;

public class ProductDBGatewayImpl implements ProductDBGateway {

    private final ProductRepository productRepository;

    public ProductDBGatewayImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductEntity> createProduct(List<ProductDto> productDtoList) {
        return List.of();
    }
}
