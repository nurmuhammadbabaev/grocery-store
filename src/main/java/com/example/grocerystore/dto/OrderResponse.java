package com.example.grocerystore.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderResponse {
    private Long id;
    private LocalDate date;
}
