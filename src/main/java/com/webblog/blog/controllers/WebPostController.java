package com.webblog.blog.controllers;

import com.webblog.blog.model.WebPost;
import com.webblog.blog.serveces.WebPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WebPostController {

    private final WebPostService webPostService;

    @Autowired
    public WebPostController(WebPostService webPostService) {
        this.webPostService = webPostService;
    }

    @PostMapping("/postBlog")
    public ResponseEntity<WebPost> createWebPost(@RequestBody WebPost webPost) {
        try {
            WebPost createdWebPost = webPostService.createWebPost(webPost);
            return new ResponseEntity<>(createdWebPost, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}