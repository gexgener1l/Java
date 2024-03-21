package com.webblog.blog.serveces;

import lombok.extern.slf4j.Slf4j;
import com.webblog.blog.dtoClasses.AuthorDTO;
import com.webblog.blog.component.AuthorCache;
import com.webblog.blog.model.Author;
import com.webblog.blog.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorCache authorCache; // Добавьте поле AuthorCache

    @Autowired
    public AuthorService(AuthorRepository authorRepository, AuthorCache authorCache) {
        this.authorRepository = authorRepository;
        this.authorCache = authorCache;
    }
    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        log.info("find all authors.");
        return authors.stream()
                .map(this::convertToDTO)
                .toList();  // Use Stream.toList() instead of Collectors.toList()
    }

    public AuthorDTO getAuthorById(Long id) {
        AuthorDTO cachedAuthor = authorCache.get(id);
        if (cachedAuthor != null) {
            System.out.println("data getted from cache.");
            log.info("data getted from cache.");
            System.out.println("Chach:"+cachedAuthor);
            log.info("Cache="+cachedAuthor);
            return cachedAuthor;
        }

        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found with id: " + id));

        AuthorDTO authorDTO = convertToDTO(author);
        authorCache.put(id, authorDTO);

        System.out.println("data getted from database.");
        log.info("data getted from database.");
        log.info("find author with id:"+id);
        return authorDTO;
    }

    public AuthorDTO saveAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        author.setTopicsId(authorDTO.getTopicsId());
        author = authorRepository.save(author);
        return convertToDTO(author);
    }


    public void deleteAuthor(Long id) {
        authorCache.evict(id);
        System.out.println("data deleted from cache.");
        log.info("data deleted from cache.");
        log.info("deleted user with id:"+id);
        authorRepository.deleteById(id);
    }

    private AuthorDTO convertToDTO(Author author) {
        return new AuthorDTO(author.getId(), author.getName(), author.getTopicsId());
    }


    public AuthorDTO updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO updatedAuthorDTO) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found with id: " + id));

        // Update the existing author's properties
        existingAuthor.setName(updatedAuthorDTO.getName());
        existingAuthor.setTopicsId(updatedAuthorDTO.getTopicsId());

        // Save the updated author
        existingAuthor = authorRepository.save(existingAuthor);

        return convertToDTO(existingAuthor);
    }
    public List<AuthorDTO> getAuthorsByTopicId(Long topicId) {
        List<Author> authors = authorRepository.findAuthorsByTopicId(topicId);
        return authors.stream()
                .map(this::convertToDTO)
                .toList();
    }
}
