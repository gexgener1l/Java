package com.webblog.blog.repository;

import com.webblog.blog.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    // Custom queries, if needed
}