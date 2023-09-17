package com.example.grocerystore.mapper;

import com.example.grocerystore.dto.ReportResponse;
import com.example.grocerystore.entity.Report;

import java.util.List;

public interface ReportMapper {

    ReportResponse toDto(Report report);

    List<ReportResponse> toDto(List<Report> reports);

}
