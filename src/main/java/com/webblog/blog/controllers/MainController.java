package com.webblog.blog.controllers;

import com.webblog.blog.model.WebPost;
import com.webblog.blog.repository.WebPostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    private final WebPostRepository webPostRepository;

    public MainController(WebPostRepository webPostRepository) {
        this.webPostRepository = webPostRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<WebPost> webPosts = webPostRepository.findAll(); // Fetch posts from the database
        model.addAttribute("webPosts", webPosts);
        return "web-blog";
    }
    @GetMapping("/getPost/{postId}")
    public ResponseEntity<WebPost> getPostDetails(@PathVariable Long postId) {
        Optional<WebPost> optionalWebPost = webPostRepository.findById(postId);
        return optionalWebPost.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deletePost/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId) {
        try {
            webPostRepository.deleteById(postId);
            return ResponseEntity.ok("Post deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting post");
        }
    }
    @PutMapping("/updatePost/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable Long postId, @RequestBody WebPost updatedPost) {
        try {
            Optional<WebPost> optionalWebPost = webPostRepository.findById(postId);
            if (optionalWebPost.isPresent()) {
                WebPost existingPost = optionalWebPost.get();

                existingPost.setTitle(updatedPost.getTitle());
                existingPost.setContent(updatedPost.getContent());

                webPostRepository.save(existingPost);

                return ResponseEntity.ok("Post updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating post");
        }
    }

}
