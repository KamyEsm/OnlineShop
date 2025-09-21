package org.example.onlineshop.Repositories;

import org.example.onlineshop.Entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentR extends JpaRepository<Comment, Long> {
}
