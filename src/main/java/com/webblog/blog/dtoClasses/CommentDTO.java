package com.webblog.blog.dtoClasses;

public class CommentDTO {

    private String text;
    private Long postId;

    public CommentDTO() {
        // Пустой конструктор для десериализации JSON
    }

    public CommentDTO(String text, Long postId) {
        this.text = text;
        this.postId = postId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}