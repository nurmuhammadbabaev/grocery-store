package com.example.grocerystore.dto;

import lombok.Data;

@Data
public class PhotoResponse {
    private Long id;
    private String photoName;
    private String type;
    private Long size;
    private String path;
}
