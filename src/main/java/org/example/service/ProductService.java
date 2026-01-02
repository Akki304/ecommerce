package org.example.service;


import org.example.dto.ProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ProductService
{
    ResponseEntity<List<ProductDto>>  getAllProducts();
}
