package com.webblog.blog.controllers;

import com.webblog.blog.dto_classes.ResponseDTO;
import com.webblog.blog.serveces.CheckerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

    @GetMapping("/check")

    public ResponseEntity<ResponseDTO> checkSite(@RequestParam String url) {
        return CheckerService.checkSite(url);
    }
}