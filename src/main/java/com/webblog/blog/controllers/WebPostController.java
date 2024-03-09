package com.webblog.blog.controllers;

import com.webblog.blog.model.WebPost;
import com.webblog.blog.repository.WebPostRepository;
import com.webblog.blog.serveces.WebPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/")
public class WebPostController {

    private final WebPostService webPostService;

    @Autowired
    public WebPostController(WebPostService webPostService) {
        this.webPostService = webPostService;
    }

    @PostMapping("/postBlog")
    public ResponseEntity<WebPost> createWebPost(WebPost webPost) {
        try {
            WebPost createdWebPost = webPostService.createWebPost(webPost);
            return new ResponseEntity<>(createdWebPost, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
