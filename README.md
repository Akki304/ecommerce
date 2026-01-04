Product Service – Spring Boot Application

This project implements a Product Management Service using Spring Boot, Spring Data JPA, and Lombok.
It provides REST APIs to add, retrieve, update, and delete products from a database.

Features

Add a new product
Fetch all products
Update an existing product
Delete a product by ID
Custom exception handling for missing products
DTO–Entity mapping using a mapper class
Logging using SLF4J


API Methods (Service Layer)

 Add Product
 
ResponseEntity<String> addProducts(ProductDto product)
Saves product data into the database
Converts ProductDto → ProductEntity
Returns success message

 Get All Products
 
List<ProductDto> getAllProducts()
Fetches all products from database
Converts ProductEntity → ProductDto
Throws ProductNotFoundException if no products exist

 Update Product
 
ResponseEntity<String> updateProduct(long id, ProductDto dto)
Validates product existence
Updates product details using Builder pattern
Preserves existing product ID

Delete Product

ResponseEntity<String> deleteProduct(long id)
Validates product existence
Deletes product by ID

