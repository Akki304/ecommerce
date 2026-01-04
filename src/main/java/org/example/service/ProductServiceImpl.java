package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.dto.ProductDto;
import org.example.entity.ProductEntity;
import org.example.exception.ProductNotFoundException;
import org.example.mapper.ProductMapper;
import org.example.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import static org.example.mapper.ProductMapper.toEntity;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    @Override
    public ResponseEntity<String> addProducts(ProductDto product) {
        productRepository.save(toEntity(product));
        log.info("Adding products to database");
        return ResponseEntity.ok("Product added successfully");
    }

    @Override
    public List<ProductDto> getAllProducts() {
       List<ProductDto> products= productRepository.findAll()
                .stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
       if(products.isEmpty())
           throw new ProductNotFoundException("No Products found in database");
       log.info("Retrieved products from database");
       return products;

    }

    @Override
    public ResponseEntity<String> deleteProduct(long id) {
        validateProductExist(id);

            log.info("Deleting product with id: {}", id);
            productRepository.deleteById(id);
            return ResponseEntity.ok("Product deleted successfully");


    }


    @Override
    public ResponseEntity<String> updateProduct(long id, ProductDto dto) {
        ProductEntity existing = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));

        ProductEntity updated = ProductEntity.builder()
                .id(existing.getId())
                .title(dto.getTitle())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .category(dto.getCategory())
                .currency(dto.getCurrency())
                .image(dto.getImage())
                .build();

        productRepository.save(updated);

        log.info("Updated product with id {}: {}", id, updated);
        return ResponseEntity.ok("Product updated successfully");
    }


    private void validateProductExist(long id)
    {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Id Not found in databases: " + id);
        }
    }


}
