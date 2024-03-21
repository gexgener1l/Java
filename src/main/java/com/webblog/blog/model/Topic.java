package com.webblog.blog.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @ManyToMany(mappedBy = "topics")
    private Set<Author> authors;

    @ElementCollection
    @CollectionTable(name = "topic_author", joinColumns = @JoinColumn(name = "topic_id"))
    @Column(name = "author_id")
    private Set<Long> authorsId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Long> getAuthorsId() {
        return authorsId;
    }

    public void setAuthorsId(Set<Long> authorsId) {
        this.authorsId = authorsId;
    }

}