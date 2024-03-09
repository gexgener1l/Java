package com.webblog.blog.serveces;

import com.webblog.blog.dtoclasses.AuthorDTO;
import com.webblog.blog.model.Author;
import com.webblog.blog.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(this::convertToDTO)
                .toList();  // Use Stream.toList() instead of Collectors.toList()
    }

    public AuthorDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Author not found with id: " + id));
        return convertToDTO(author);
    }

    public AuthorDTO saveAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        author.setTopicsId(authorDTO.getTopicsId());
        author = authorRepository.save(author);
        return convertToDTO(author);
    }


    public void deleteAuthor(Long id) {
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

}
