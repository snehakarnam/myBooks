package com.mybooks.app.subscription.repository.DBGatewayImpl;



import com.mybooks.app.subscription.dto.ProductDto;
import com.mybooks.app.subscription.entity.ProductEntity;
import com.mybooks.app.subscription.repository.Mapper.ProductEntityMapper;
import com.mybooks.app.subscription.repository.ProductRepository;
import com.mybooks.app.subscription.service.DBGateway.ProductDBGateway;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ProductDBGatewayImpl implements ProductDBGateway {

    private final ProductRepository productRepository;

    public ProductDBGatewayImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public List<ProductDto> createProduct(List<ProductDto> productDtoList) {
        List<ProductEntity> productEntities =productRepository.saveAll(ProductEntityMapper.MAPPER.toProductEntity(productDtoList));
        return ProductEntityMapper.MAPPER.fromProductEntity(productEntities);
    }
}
