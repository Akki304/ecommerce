package org.example.service;


import org.example.dto.ProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ProductService
{
    ResponseEntity<String> addProducts(ProductDto product);
    List<ProductDto> getAllProducts();
    ResponseEntity<String> deleteProduct(long id);
    ResponseEntity<String> updateProduct(long id, ProductDto dto);
}
