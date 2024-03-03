package com.webblog.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class WebPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String content;
    private Date createdAt;  // Дата создания поста

//     Конструктор без параметров (для JPA)
    public WebPost() {
        this.createdAt = new Date();
    }

//     Конструктор с параметрами
    public WebPost(String title, String content) {
        this.title = title;
        this.content = content;
        this.createdAt = new Date();
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

    public Date getCreatedAt() {
        return createdAt;
    }

    // Другие методы, если необходимо
}