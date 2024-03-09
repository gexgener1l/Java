package com.webblog.blog.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "author_topics",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "topic_id"))
    private Set<Topic> topics;

    @ElementCollection
    @CollectionTable(name = "author_topics", joinColumns = @JoinColumn(name = "author_id"))
    @Column(name = "topic_id")
    private Set<Long> topicsId;

    // Constructors, if needed


    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for topics
    public Set<Topic> getTopics() {
        return topics;
    }

    public void setTopics(Set<Topic> topics) {
        this.topics = topics;
    }

    // Getter and setter for topicsId
    public Set<Long> getTopicsId() {
        return topicsId;
    }

    public void setTopicsId(Set<Long> topicsId) {
        this.topicsId = topicsId;
    }

    // Additional getters and setters, if needed
}
