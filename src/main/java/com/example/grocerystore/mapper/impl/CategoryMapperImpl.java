package com.example.grocerystore.mapper.impl;

import com.example.grocerystore.dto.CategoryResponse;
import com.example.grocerystore.dto.UserResponse;
import com.example.grocerystore.entity.Category;
import com.example.grocerystore.mapper.CategoryMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public CategoryResponse toDto(Category category) {
        CategoryResponse response = new CategoryResponse();
        response.setId(category.getId());
        response.setName(category.getName());
        return response;
    }

    @Override
    public List<CategoryResponse> toDto(List<Category> categories) {
        List<CategoryResponse> categoryResponseList = new ArrayList<>();
        for (Category category : categories) {
            categoryResponseList.add(toDto(category));
        }
        return categoryResponseList.stream().sorted(Comparator.comparing(CategoryResponse::getId)).collect(Collectors.toList());
    }
}
