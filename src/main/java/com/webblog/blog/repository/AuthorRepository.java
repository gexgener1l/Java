package com.webblog.blog.repository;

import com.webblog.blog.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a JOIN a.topics t WHERE t.id = :topicId")
    List<Author> findAuthorsByTopicId(@Param("topicId") Long topicId);
}