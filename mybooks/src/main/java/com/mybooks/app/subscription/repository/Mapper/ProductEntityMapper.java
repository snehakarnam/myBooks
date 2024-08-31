package com.mybooks.app.subscription.repository.Mapper;


import com.mybooks.app.subscription.dto.ProductDto;
import com.mybooks.app.subscription.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public interface ProductEntityMapper {

    ProductEntityMapper MAPPER = new ProductEntityMapper() {


        @Override
        public ProductDto fromProductEntity(ProductEntity productEntity) {
            return null;
        }

        @Override
        public List<ProductEntity> toProductEntity(List<ProductDto> productDto) {
            return productDto.stream()
                    .map(this::toEntity)
                    .collect(Collectors.toList());
        }

        private ProductEntity toEntity(ProductDto productDto) {
            if (productDto == null) {
                return null;
            }
            ProductEntity productEntity = new ProductEntity();
//            productEntity.se(productDto.getVendorId());
//            productEntity.setProductName(productDto.getProductName());
//            productEntity.setDescription(productDto.getDescription());
//            productEntity.setPrice(productDto.getPrice());
            return productEntity;
        }
    };

    ProductDto fromProductEntity(ProductEntity productEntity);
    List<ProductEntity> toProductEntity(List<ProductDto> productDto);
}
