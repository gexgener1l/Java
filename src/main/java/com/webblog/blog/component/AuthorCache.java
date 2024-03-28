package com.webblog.blog.component;

import com.webblog.blog.dtoClasses.AuthorDTO;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
//
@Component
public class AuthorCache {

    private final Map<Long, AuthorDTO> cache = new ConcurrentHashMap<>();

    public AuthorDTO get(Long authorId) {
        return cache.get(authorId);
    }

    public void put(Long authorId, AuthorDTO authorDTO) {
        cache.put(authorId, authorDTO);
    }

    public void evict(Long authorId) {
        cache.remove(authorId);
    }
}