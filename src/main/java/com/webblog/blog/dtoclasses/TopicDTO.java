package com.webblog.blog.dtoclasses;

import java.util.Set;

public class TopicDTO {
    private Long id;
    private String name;
    private String description;
    private Set<Long> authorsId;

    public TopicDTO(Long id, String name, String description, Set<Long> authorsId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.authorsId = authorsId;
    }

    public TopicDTO() {

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Long> getAuthorsId() {
        return authorsId;
    }

    public void setAuthorsId(Set<Long> authorsId) {
        this.authorsId = authorsId;
    }
}