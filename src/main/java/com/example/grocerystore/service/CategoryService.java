package com.example.grocerystore.service;

import com.example.grocerystore.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {

    CategoryResponse findById(Long id);

    List<CategoryResponse> findAll();
}
