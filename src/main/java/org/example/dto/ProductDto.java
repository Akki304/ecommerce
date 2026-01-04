package org.example.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;


@Getter
@Builder
public class ProductDto
{
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String currency;
    private String image;

}