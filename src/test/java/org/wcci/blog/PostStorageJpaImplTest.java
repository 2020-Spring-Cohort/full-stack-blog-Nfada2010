package org.wcci.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.blog.Model.Author;
import org.wcci.blog.Model.Category;
import org.wcci.blog.Model.Post;
import org.wcci.blog.Storage.Repos.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class PostStorageJpaImplTest {
    private AuthorRepository authorRepository;
    private CategoryRepository categoryRepository;
    private PostRepository postRepository;
    private PostStorage postStorage;
    private Post post;
    private Author testAuthor;
    private Long id;

    @BeforeEach
    void setUp() {
        authorRepository = mock(AuthorRepository.class);
        categoryRepository = mock(CategoryRepository.class);
        postRepository = mock(PostRepository.class);
        postStorage = new PostStorageJpaImpl(authorRepository, categoryRepository, postRepository);
        Category category = new Category();
        Author author = new Author();
        post = new Post("PostTitle", "BodyText for the post", testAuthor, id);
    }
    @Test
    public void shouldFindPostByID(){
        when(postRepository.findById(1L)).thenReturn(Optional.of(post));
        Post retrievedPost = (Post)postStorage.findPostbyId(1L);
        assertThat(retrievedPost).isEqualTo(post);
    }

    @Test
    public void ShouldStorePost(){
        postStorage.store(post);
        verify(authorRepository).save(post.getAuthor());
        verify(categoryRepository).save(post.getCategory());
        verify(postRepository).save(post);
    }
}
