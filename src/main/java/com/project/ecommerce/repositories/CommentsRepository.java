package com.project.ecommerce.repositories;

import com.project.ecommerce.models.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

    List<Comments> findByTitle(String titleName);
}
