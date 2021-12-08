package com.project.ecommerce.repositories;

import com.project.ecommerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{

    List<User> findByName(String userName);
}
