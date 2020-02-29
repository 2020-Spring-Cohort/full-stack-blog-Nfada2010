package org.wcci.blog.Storage.Repos;

import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.Model.Post;

public interface PostRepository extends CrudRepository<Post,Long> {
}
