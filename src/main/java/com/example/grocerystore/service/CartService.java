package com.example.grocerystore.service;

import com.example.grocerystore.dto.CartResponse;

import java.util.List;

public interface CartService {

    CartResponse findById(Long id);

    List<CartResponse> findAll();
}
