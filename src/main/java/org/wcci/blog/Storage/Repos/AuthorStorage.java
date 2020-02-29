package org.wcci.blog.Storage.Repos;

import org.wcci.blog.Model.Author;

import java.util.Collection;

public interface AuthorStorage {
    Collection<Author> findAllAuthors();

    void store(Author author);

    Author findAuthorByName(String authorName);

}
