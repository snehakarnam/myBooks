package com.mybooks.app.subscription.repository.Mapper;


import com.mybooks.app.subscription.dto.ProductDto;
import com.mybooks.app.subscription.entity.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

public interface ProductEntityMapper {

    ProductEntityMapper MAPPER = new ProductEntityMapper() {


        @Override
        public List<ProductDto> fromProductEntity(List<ProductEntity> productEntity) {
            return productEntity.stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
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
//            productEntity.setVendor(productDto.getVendorId());
            productEntity.setName(productDto.getProductName());
            productEntity.setDescription(productDto.getDescription());
            productEntity.setPrice(productDto.getPrice());
            return productEntity;
        }

        private ProductDto toDto(ProductEntity productEntity) {
            if (productEntity == null) {
                return null;
            }
             ProductDto productDto = new ProductDto();
            productDto.setProductName(productEntity.getName());
            productDto.setDescription(productEntity.getDescription());
            productDto.setPrice(productEntity.getPrice());
            return productDto;
        }
    };

    List<ProductDto> fromProductEntity(List<ProductEntity> productEntity);
    List<ProductEntity> toProductEntity(List<ProductDto> productDto);
}
