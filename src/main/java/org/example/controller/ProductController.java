package org.example.controller;

import org.example.dto.ProductDto;
import org.example.service.ProductServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {


    private final ProductServiceImpl productService;
    //constructor injection
    public ProductController (ProductServiceImpl productService)
    {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@RequestBody ProductDto dto)
    {
        return productService.addProducts(dto);
    }


    @GetMapping
    public List<ProductDto> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateProducts(@PathVariable long id,@RequestBody ProductDto dto)
    {
        return productService.updateProduct(id,dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable long id)
    {
        return productService.deleteProduct(id);
    }

}
