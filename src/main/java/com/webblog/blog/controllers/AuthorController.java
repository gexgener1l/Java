package com.webblog.blog.controllers;

import com.webblog.blog.dtoClasses.AuthorDTO;
import com.webblog.blog.model.Topic;
import com.webblog.blog.serveces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<AuthorDTO> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public AuthorDTO getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping
    public AuthorDTO saveAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorService.saveAuthor(authorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

    // New methods for working with topics

//    @GetMapping("/{id}/topics")
//    public List<Topic> getTopicsByAuthorId(@PathVariable Long id) {
//        return authorService.getTopicsByAuthorId(id);
//    }
//
//    @PostMapping("/{authorId}/topics/{topicId}")
//    public void addTopicToAuthor(@PathVariable Long authorId, @PathVariable Long topicId) {
//        authorService.addTopicToAuthor(authorId, topicId);
//    }
//
//    @DeleteMapping("/{authorId}/topics/{topicId}")
//    public void removeTopicFromAuthor(@PathVariable Long authorId, @PathVariable Long topicId) {
//        authorService.removeTopicFromAuthor(authorId, topicId);
//    }
}
