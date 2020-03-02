package org.wcci.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.blog.Model.Author;
import org.wcci.blog.Model.Category;
import org.wcci.blog.Model.Post;
import org.wcci.blog.Model.Tag;
import org.wcci.blog.Storage.Repos.TagRepository;
import org.wcci.blog.Storage.Repos.TagStorage;
import org.wcci.blog.Storage.Repos.TagStorageJpaImpl;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TagStorageJpaImplTest {

    private TagRepository tagRepo;
    private TagStorage underTest;
    private Tag testTag;

    @BeforeEach
    void setUp() {
        tagRepo = mock(TagRepository.class);
        underTest = new TagStorageJpaImpl(tagRepo);
        Author testAuthor = new Author();
        Category testCategory = new Category();
        Post testPost = new Post();
        testTag = new Tag();
    }

    @Test
    public void shouldFindTagByTitle() {
        when(tagRepo.findByTitle("#fresh")).thenReturn(Optional.of(testTag));
        Tag retrievedTag = underTest.findTagByTitle("#fresh");
        assertThat(retrievedTag).isEqualTo(testTag);
    }

    @Test
    public void shouldFindTagById() {
        when(tagRepo.findById(1L)).thenReturn(Optional.of(testTag));
        Tag retrievedTag = underTest.findTagById(1L);
        assertThat(retrievedTag).isEqualTo(testTag);
    }
}