package com.webblog.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

//     Конструктор без параметров (для JPA)
    public WebPost() {
    }

//     Конструктор с параметрами
//    public WebPost(String title, String content) {
//        this.title = title;
//        this.content = content;
//        this.createdAt = new Date();
//    }

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

    // Другие методы, если необходимо
}