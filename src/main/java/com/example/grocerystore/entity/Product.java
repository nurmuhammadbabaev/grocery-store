package com.example.grocerystore.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
public class Product {  //Продукты
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Photo photo;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Category category;

}
