package com.mybooks.app.subscription.service.DBGateway;


import com.mybooks.app.subscription.dto.ProductDto;
import com.mybooks.app.subscription.entity.ProductEntity;

import java.util.List;

public interface ProductDBGateway {
    List<ProductEntity> createProduct(List<ProductDto> productDtoList);
}
