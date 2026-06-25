package com.ecommerce.project.repositories;

import com.ecommerce.project.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
