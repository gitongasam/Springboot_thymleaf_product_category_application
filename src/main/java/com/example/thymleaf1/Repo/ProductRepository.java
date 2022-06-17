package com.example.thymleaf1.Repo;

import com.example.thymleaf1.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
