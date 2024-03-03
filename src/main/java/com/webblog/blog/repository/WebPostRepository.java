package com.webblog.blog.repository;

import com.webblog.blog.model.WebPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebPostRepository extends JpaRepository<WebPost, Long> {
}