package org.example.controller;

import org.example.dto.ProductDto;
import org.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductDto>> getAllProduct()
    {
        return productService.getAllProducts();
    }

}
