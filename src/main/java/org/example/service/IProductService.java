package org.example.service;

import org.example.dto.ProductDto;
import org.example.gateway.ClientGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProductService implements ProductService {
    @Autowired
    ClientGateway clientGateway;

    public ResponseEntity<List<ProductDto>>  getAllProducts()
    {
        return clientGateway.listOfProducts();
    }

}
