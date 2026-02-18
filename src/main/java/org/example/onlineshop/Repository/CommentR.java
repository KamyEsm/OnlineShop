package org.example.onlineshop.Repository;

import org.example.onlineshop.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentR extends JpaRepository<Comment, Long> {
}
