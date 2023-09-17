package com.example.grocerystore.service;

import com.example.grocerystore.dto.PhotoResponse;
import com.example.grocerystore.entity.Photo;

import java.io.FileNotFoundException;
import java.util.List;

public interface PhotoService {

    PhotoResponse findById(Long id);

    List<PhotoResponse> findAll();

    Photo create(String urlPhoto) throws FileNotFoundException;
}
