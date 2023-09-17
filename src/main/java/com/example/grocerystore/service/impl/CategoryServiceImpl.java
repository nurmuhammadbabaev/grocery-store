package com.example.grocerystore.service.impl;

import com.example.grocerystore.dto.CategoryResponse;
import com.example.grocerystore.mapper.CategoryMapper;
import com.example.grocerystore.repository.CategoryRepository;
import com.example.grocerystore.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse findById(Long id) {
        return categoryMapper.toDto(categoryRepository.findById(id).orElseThrow());
    }

    @Override
    public List<CategoryResponse> findAll() {
        return categoryMapper.toDto(categoryRepository.findAll());
    }
}
