package com.example.thymleaf1.Product;

import com.example.thymleaf1.Category.Category;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;



}
