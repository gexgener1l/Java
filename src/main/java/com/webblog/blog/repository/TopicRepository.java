package com.webblog.blog.repository;

import com.webblog.blog.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    // Custom queries, if needed
}