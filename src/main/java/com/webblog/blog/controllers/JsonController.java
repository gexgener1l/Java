package com.webblog.blog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonController {

    @GetMapping("/json1")
    public String getJsonData(@RequestParam(name = "param1", defaultValue = "default1") String param1,
                              @RequestParam(name = "param2", defaultValue = "default2") String param2) {

        // Здесь можно произвести необходимую обработку параметров
        // Например, создать объект и преобразовать его в JSON

        return "{"
                + "\"param1\":\"" + param1 + "\","
                + "\"param2\":\"" + param2 + "\""
                + "}";
    }
}