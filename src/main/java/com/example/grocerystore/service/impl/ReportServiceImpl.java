package com.example.grocerystore.service.impl;

import com.example.grocerystore.dto.ReportResponse;
import com.example.grocerystore.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    @Override
    public ReportResponse findById(Long id) {
        return null;
    }

    @Override
    public List<ReportResponse> findAll() {
        return null;
    }
}
