package com.project.ecommerce.repositories;

import com.project.ecommerce.models.Product;
import com.project.ecommerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
