package com.example.grocerystore.mapper.impl;

import com.example.grocerystore.dto.ProductResponse;
import com.example.grocerystore.entity.Product;
import com.example.grocerystore.mapper.PhotoMapper;
import com.example.grocerystore.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductMapperImpl implements ProductMapper {
    private PhotoMapper photoMapper;


    @Override
    public ProductResponse toDto(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        if (product.getPhoto() != null) {
            response.setPhoto(photoMapper.toDto(product.getPhoto()));
        }
        return response;
    }

    @Override
    public List<ProductResponse> toDto(List<Product> products) {
        List<ProductResponse> productResponseList = new ArrayList<>();
        for (Product product : products) {
            productResponseList.add(toDto(product));
        }
        return productResponseList.stream().sorted(Comparator.comparing(ProductResponse::getId)).collect(Collectors.toList());
    }
}
