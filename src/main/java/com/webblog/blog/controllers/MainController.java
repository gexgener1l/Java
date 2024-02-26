package com.webblog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                       @RequestParam(name = "title", required = false, defaultValue = "Default Title") String title,
                       Model model) {
        setModelAttributes(name, title, model);
        return "home";
    }

    private void setModelAttributes(String name, String title, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("title", title);
    }

}
