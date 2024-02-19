package com.webblog.blog.controllers;

import com.webblog.blog.serveces.CheckerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

    //private final CheckerService websiteCheckerService = new CheckerService();
    @GetMapping("/json1")
    public String getJsonData(@RequestParam(name = "param1", defaultValue = "default1") String param1,
                              @RequestParam(name = "param2", defaultValue = "default2") String param2) {

        return "{"
                + "\"param1\":\"" + param1 + "\","
                + "\"param2\":\"" + param2 + "\""
                + "}";
    }
    @GetMapping("/check")

    public String checkSite(@RequestParam String url) {
        return CheckerService.checkSite(url);
    }
}