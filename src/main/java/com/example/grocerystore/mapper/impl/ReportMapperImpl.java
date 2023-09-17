package com.example.grocerystore.mapper.impl;

import com.example.grocerystore.dto.ReportResponse;
import com.example.grocerystore.dto.UserResponse;
import com.example.grocerystore.entity.Report;
import com.example.grocerystore.mapper.ReportMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReportMapperImpl implements ReportMapper {

    @Override
    public ReportResponse toDto(Report report) {
        ReportResponse response = new ReportResponse();
        response.setId(report.getId());
        response.setDate(report.getDate());
        response.setType(report.getType());
        response.setText(report.getText());
        return response;
    }

    @Override
    public List<ReportResponse> toDto(List<Report> reports) {
        List<ReportResponse> reportResponseList = new ArrayList<>();
        for (Report report : reports) {
            reportResponseList.add(toDto(report));
        }
        return reportResponseList.stream().sorted(Comparator.comparing(ReportResponse::getId)).collect(Collectors.toList());
    }
}
