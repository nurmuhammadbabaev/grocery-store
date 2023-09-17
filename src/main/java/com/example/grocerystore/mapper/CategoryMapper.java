package com.example.grocerystore.mapper;

import com.example.grocerystore.dto.CategoryResponse;
import com.example.grocerystore.entity.Category;

import java.util.List;

public interface CategoryMapper {

    CategoryResponse toDto(Category category);

    List<CategoryResponse> toDto(List<Category> categories);

}
