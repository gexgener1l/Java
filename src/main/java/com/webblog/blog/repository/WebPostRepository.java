package com.webblog.blog.repository;

import com.webblog.blog.model.Comment;
import com.webblog.blog.model.WebPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebPostRepository extends JpaRepository<WebPost, Long> {
}

