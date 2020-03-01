package org.wcci.blog.Storage.Repos;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.Model.Author;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository <Author, Long>{

    Optional<Author> findByAuthorName(String authorName);
}
