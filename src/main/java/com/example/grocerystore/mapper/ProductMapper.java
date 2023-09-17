package com.example.grocerystore.mapper;

import com.example.grocerystore.dto.ProductResponse;
import com.example.grocerystore.entity.Product;

import java.util.List;

public interface ProductMapper {
    ProductResponse toDto(Product product);

    List<ProductResponse> toDto(List<Product> products);
}
