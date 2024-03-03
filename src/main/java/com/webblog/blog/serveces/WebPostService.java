package com.webblog.blog.serveces;

import com.webblog.blog.repository.WebPostRepository;
import com.webblog.blog.model.WebPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WebPostService {

    private final WebPostRepository webPostRepository;

    @Autowired
    public WebPostService(WebPostRepository webPostRepository) {
        this.webPostRepository = webPostRepository;
    }

    public ResponseEntity<WebPost> createWebPost(WebPost webPost) {
        try {
            WebPost createdWebPost = webPostRepository.save(webPost);
            return ResponseEntity.ok(createdWebPost);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
