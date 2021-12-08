package com.project.ecommerce.repositories;

import com.project.ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{

    List<Product> findByName(String nameProduct);
}
