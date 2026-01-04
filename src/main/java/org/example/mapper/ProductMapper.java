package org.example.mapper;

import org.example.dto.ProductDto;
import org.example.entity.ProductEntity;

public class ProductMapper {

    public static ProductEntity toEntity(ProductDto dto) {
        return ProductEntity.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .category(dto.getCategory())
                .currency(dto.getCurrency())
                .image(dto.getImage())
                .build();
    }

    public static ProductDto toDto(ProductEntity product) {
        return ProductDto.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .description(product.getDescription())
                .category(product.getCategory())
                .currency(product.getCurrency())
                .image(product.getImage())
                .build();
    }
}
