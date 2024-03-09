package com.webblog.blog.serveces;

import com.webblog.blog.dtoclasses.CommentDTO;
import com.webblog.blog.model.Comment;
import com.webblog.blog.repository.CommentRepository;
import com.webblog.blog.repository.WebPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final WebPostRepository webPostRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, WebPostRepository webPostRepository) {
        this.commentRepository = commentRepository;
        this.webPostRepository = webPostRepository;
    }

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }

    public Comment addComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setPost(webPostRepository.findById(commentDTO.getPostId())
                .orElseThrow(() -> new RuntimeException("Post not found")));
        comment.setText(commentDTO.getText());
        // Установите остальные значения из commentDTO, если они есть

        return commentRepository.save(comment);
    }

    public Comment updateComment(Long commentId, CommentDTO commentDTO) {
        Comment existingComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        // Обновите значения комментария
        existingComment.setText(commentDTO.getText());
        // Обновите другие значения по необходимости

        return commentRepository.save(existingComment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }
}