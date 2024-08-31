package com.mybooks.app.subscription.service.DBGateway;


import com.mybooks.app.subscription.dto.ProductDto;
import com.mybooks.app.subscription.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductDBGateway {
    List<ProductDto> createProduct(List<ProductDto> productDtoList);
}
