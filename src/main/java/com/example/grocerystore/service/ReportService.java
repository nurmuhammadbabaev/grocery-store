package com.example.grocerystore.service;

import com.example.grocerystore.dto.ReportResponse;

import java.util.List;

public interface ReportService {

    ReportResponse findById(Long id);

    List<ReportResponse> findAll();
}
