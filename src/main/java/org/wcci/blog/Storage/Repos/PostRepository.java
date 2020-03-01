package org.wcci.blog.Storage.Repos;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.Model.Post;

import java.util.Optional;

public interface PostRepository extends CrudRepository<Post,Long> {

    Optional<Post> findPostById(long id);
}
