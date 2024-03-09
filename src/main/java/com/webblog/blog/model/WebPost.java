package com.webblog.blog.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
//@Table(name = "web_post")
public class WebPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "web_post_seq", sequenceName = "web_post_seq", allocationSize = 1)
    private Long id;

    private String title;
    private String content;
    private Date createdAt;  // Дата создания поста

    /**
     * Default constructor for WebPost.
     *
     * <p>This constructor is intentionally left empty. If specific initialization logic is
     * required, it should be implemented in a parameterized constructor or initialization
     * methods to ensure proper object creation.
     */
    public WebPost() {
        // Empty constructor as no specific initialization logic is needed.
        // If necessary, consider adding specific initialization logic in other constructors or methods.
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }
}