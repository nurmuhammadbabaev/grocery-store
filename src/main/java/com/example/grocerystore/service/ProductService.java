package com.example.grocerystore.service;

import com.example.grocerystore.dto.ProductRequest;
import com.example.grocerystore.dto.ProductResponse;
import com.example.grocerystore.entity.Product;

import java.io.FileNotFoundException;
import java.util.List;

public interface ProductService {
    List<ProductResponse> searchProducts(String query);

    ProductResponse create(ProductRequest productRequest) throws FileNotFoundException;

    ProductResponse findById(Long id);

    ProductResponse update(Long id, ProductRequest productRequest) throws FileNotFoundException;

    void delete(Long id);
}
