package org.wcci.blog.Storage.Repos;

import org.springframework.stereotype.Service;
import org.wcci.blog.Model.Post;
@Service
public class PostStorageJpaImpl implements PostStorage{
    private PostRepository postRepository;

    public PostStorageJpaImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }
    @Override
    public void store(Post post) {

    }

    @Override
    public Post findPostbyId(long id) {
        return postRepository.findById(id).get();
    }
}
