package com.webblog.blog.controllers;

import com.webblog.blog.dtoClasses.AuthorDTO;
import com.webblog.blog.model.Author;
import com.webblog.blog.repository.AuthorRepository;
import com.webblog.blog.serveces.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

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

    @PutMapping("/{id}")
    public AuthorDTO updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO updatedAuthorDTO) {
        return authorService.updateAuthor(id, updatedAuthorDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

    // 2. Добавьте GET-эндпоинт с параметром
    @GetMapping("/by-topic")
    public ResponseEntity<List<AuthorDTO>> getAuthorsByTopic(@RequestParam Long topicId) {
        List<AuthorDTO> authors = authorService.getAuthorsByTopicId(topicId);

        if (authors.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(authors);
        }
    }
}
