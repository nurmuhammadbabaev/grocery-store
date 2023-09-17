package com.example.grocerystore.mapper;

import com.example.grocerystore.dto.PaymentMethodResponse;
import com.example.grocerystore.entity.PaymentMethod;

import java.util.List;

public interface PaymentMethodMapper {
    PaymentMethodResponse toDto(PaymentMethod paymentMethod);

    List<PaymentMethodResponse> toDto(List<PaymentMethod> paymentMethods);
}
