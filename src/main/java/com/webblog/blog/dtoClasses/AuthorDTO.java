package com.webblog.blog.dtoClasses;

import java.util.Set;

public class AuthorDTO {
    private Long id;
    private String name;
    private Set<Long> topicsId;

    // Constructors
    public AuthorDTO() {
    }

    public AuthorDTO(Long id, String name, Set<Long> topicsId) {
        this.id = id;
        this.name = name;
        this.topicsId = topicsId;
    }

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

    // Getter and setter for topicsId
    public Set<Long> getTopicsId() {
        return topicsId;
    }

    public void setTopicsId(Set<Long> topicsId) {
        this.topicsId = topicsId;
    }

    // Additional methods, if needed
}
