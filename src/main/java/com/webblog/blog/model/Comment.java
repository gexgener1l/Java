package com.webblog.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webblog.blog.model.WebPost;
import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private WebPost post;

    // Constructors, getters, and setters

    public Comment() {
        // Default constructor
    }

    public Comment(String text, WebPost post) {
        this.text = text;
        this.post = post;
    }

    // Getter and Setter for 'text'
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // Getter and Setter for 'id'
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and Setter for 'post'
    public WebPost getPost() {
        return post;
    }

    public void setPost(WebPost post) {
        this.post = post;
    }
}
