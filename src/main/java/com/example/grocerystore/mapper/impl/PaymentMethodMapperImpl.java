package com.example.grocerystore.mapper.impl;

import com.example.grocerystore.dto.PaymentMethodResponse;
import com.example.grocerystore.dto.UserResponse;
import com.example.grocerystore.entity.PaymentMethod;
import com.example.grocerystore.mapper.PaymentMethodMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentMethodMapperImpl implements PaymentMethodMapper {

    @Override
    public PaymentMethodResponse toDto(PaymentMethod paymentMethod) {
        PaymentMethodResponse response = new PaymentMethodResponse();
        response.setId(paymentMethod.getId());
        response.setPaymentMethod(paymentMethod.getPaymentMethod());
        return response;
    }

    @Override
    public List<PaymentMethodResponse> toDto(List<PaymentMethod> paymentMethods) {
        List<PaymentMethodResponse> paymentMethodResponseList = new ArrayList<>();
        for (PaymentMethod paymentMethod : paymentMethods) {
            paymentMethodResponseList.add(toDto(paymentMethod));
        }
        return paymentMethodResponseList.stream().sorted(Comparator.comparing(PaymentMethodResponse::getId)).collect(Collectors.toList());
    }
}
