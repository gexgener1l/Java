package com.webblog.blog.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "topics")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToMany(mappedBy = "topics")
    private Set<Author> authors;

    @ElementCollection
    @CollectionTable(name = "topic_authors", joinColumns = @JoinColumn(name = "topic_id"))
    @Column(name = "author_id")
    private Set<Long> authorsId;

    // Constructors, if needed

    // Getter and setter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and setter for authors
    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    // Getter and setter for authorsId
    public Set<Long> getAuthorsId() {
        return authorsId;
    }

    public void setAuthorsId(Set<Long> authorsId) {
        this.authorsId = authorsId;
    }

    // Additional getters and setters, if needed
}