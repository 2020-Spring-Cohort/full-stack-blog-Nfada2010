package org.wcci.blog.Storage.Repos;

import org.springframework.stereotype.Service;
import org.wcci.blog.Model.Author;

import java.util.Collection;

@Service
public class AuthorStorageJpaImpl implements AuthorStorage {
    private AuthorRepository authorRepository;

    public AuthorStorageJpaImpl(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @Override
    public Collection<Author> getAll(){return (Collection<Author>)authorRepository.findAll();}
    @Override
    public void store(Author author) {

    }

    @Override
    public Author findAuthorByName(String authorName) {
        return authorRepository.findByAuthorName(authorName).get();
    }
}
