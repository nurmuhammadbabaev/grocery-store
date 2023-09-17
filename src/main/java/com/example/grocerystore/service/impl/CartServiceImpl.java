package com.example.grocerystore.service.impl;

import com.example.grocerystore.dto.CartResponse;
import com.example.grocerystore.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {

    @Override
    public CartResponse findById(Long id) {
        return null;
    }

    @Override
    public List<CartResponse> findAll() {
        return null;
    }
}
