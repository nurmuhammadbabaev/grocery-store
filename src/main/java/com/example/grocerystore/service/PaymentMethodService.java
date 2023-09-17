package com.example.grocerystore.service;

import com.example.grocerystore.dto.PaymentMethodResponse;

import java.util.List;

public interface PaymentMethodService {

    PaymentMethodResponse findById(Long id);

    List<PaymentMethodResponse> findAll();
}
