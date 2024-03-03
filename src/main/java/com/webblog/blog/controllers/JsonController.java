package com.webblog.blog.controllers;

import com.webblog.blog.dtoClasses.CheckerDTO;
import com.webblog.blog.model.WebPost;
import com.webblog.blog.serveces.CheckerService;
import com.webblog.blog.serveces.WebPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JsonController {

    private final WebPostService webPostService;

    @Autowired
    public JsonController(WebPostService webPostService) {
        this.webPostService = webPostService;
    }

    @GetMapping("/check")
    public ResponseEntity<CheckerDTO> checkSite(@RequestParam String url) {
        return CheckerService.checkSite(url);
    }

    @PostMapping("/webpost")
    public ResponseEntity<WebPost> createWebPost(@RequestBody WebPost webPostDTO) {
        return webPostService.createWebPost(webPostDTO);
    }
}