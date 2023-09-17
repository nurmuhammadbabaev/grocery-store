package com.example.grocerystore.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReportResponse {
    private Long id;
    private String type;
    private LocalDate date;
    private String text;
}
