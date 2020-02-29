package org.wcci.blog.Storage.Repos;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.Model.Author;
import org.wcci.blog.Model.Post;

import java.util.List;

public interface TagRepository extends CrudRepository <Post, Author> {

    Author findByAuthor(Author author);
}
