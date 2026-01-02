package org.example.gateway;
import org.example.dto.ProductDto;
import org.example.exception.ExternalServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class ClientGateway
{
    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<List<ProductDto>> listOfProducts()
    {
        String uri = "https://fakestoreapi.com/products";
       try {
           return restTemplate.exchange(
                   uri,
                   HttpMethod.GET,
                   null,
                   new ParameterizedTypeReference<List<ProductDto>>() {
                   }
           );
       }
       catch (Exception ex)
       {
           throw new ExternalServiceException(
                   "Failed to fetch products from external API",
                   ex
           );
       }
    }

}
