package com.example.grocerystore.service.impl;

import com.example.grocerystore.dto.PaymentMethodResponse;
import com.example.grocerystore.service.PaymentMethodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Override
    public PaymentMethodResponse findById(Long id) {
        return null;
    }

    @Override
    public List<PaymentMethodResponse> findAll() {
        return null;
    }
}
