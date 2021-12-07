package com.project.ecommerce.repositories;

import com.project.ecommerce.models.Category;
import com.project.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
