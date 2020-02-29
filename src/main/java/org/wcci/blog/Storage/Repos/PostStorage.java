package org.wcci.blog.Storage.Repos;

import org.wcci.blog.Model.Post;

public interface PostStorage {

    void store(Post post);

    Post findPostbyId(long id);
}
