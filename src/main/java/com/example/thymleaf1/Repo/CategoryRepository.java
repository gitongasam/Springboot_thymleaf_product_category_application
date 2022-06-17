package com.example.thymleaf1.Repo;

import com.example.thymleaf1.Category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
