package com.webblog.blog.serveces;

import com.webblog.blog.repository.WebPostRepository;
import com.webblog.blog.model.WebPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WebPostService {

    private final WebPostRepository webPostRepository;

    @Autowired
    public WebPostService(WebPostRepository webPostRepository) {
        this.webPostRepository = webPostRepository;
    }

    public WebPost createWebPost(WebPost webPost) {
        webPost.setCreatedAt(new Date());
        return webPostRepository.save(webPost);
    }
}
