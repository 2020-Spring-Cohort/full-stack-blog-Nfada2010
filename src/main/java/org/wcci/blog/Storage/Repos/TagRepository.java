package org.wcci.blog.Storage.Repos;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.Model.Author;
import org.wcci.blog.Model.Post;
import org.wcci.blog.Model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagRepository extends CrudRepository <Tag, Long> {

    Optional<Tag>  findByTitle(String title);
}
