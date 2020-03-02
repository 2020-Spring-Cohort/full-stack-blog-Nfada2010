package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.wcci.blog.Model.Author;
import org.wcci.blog.Storage.Repos.AuthorRepository;
import org.wcci.blog.Storage.Repos.AuthorStorage;
import org.wcci.blog.Storage.Repos.AuthorStorageJpaImpl;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AuthorStorageJpaImplTest {

    @Test
    public void shouldStoreAuthor() {
        AuthorRepository authorRepository = mock(AuthorRepository.class);
        AuthorStorage storage = new AuthorStorageJpaImpl(authorRepository);
        Author testAuthor = new Author();
        when(authorRepository.findAll()).thenReturn(Collections.singletonList(testAuthor));
        storage.store(testAuthor);
        verify(authorRepository).save(testAuthor);
        assertThat(storage.getAll()).contains(testAuthor);
    }


    @Test
    public void shouldRetrieveSingleAuthorByName() {
        AuthorRepository mockRepo = mock(AuthorRepository.class);
        Author testAuthor1 = new Author();
        Author testAuthor2 = new Author();
        AuthorStorage underTest = new AuthorStorageJpaImpl(mockRepo);
        underTest.store(testAuthor1);
        underTest.store(testAuthor2);
        Optional<Author> testAuthor1Optional = Optional.of(testAuthor1);
        when(mockRepo.findByAuthorName("user")).thenReturn(testAuthor1Optional);

        Optional<Author> testAuthor2Optional = Optional.of(testAuthor2);
        when(mockRepo.findByAuthorName("user2")).thenReturn(testAuthor2Optional);

        Author retrievedAuthor1 = underTest.findAuthorByName("user");
        Author retrievedAuthor2 = underTest.findAuthorByName("user2");
        assertThat(retrievedAuthor1).isEqualTo(testAuthor1);
        assertThat(retrievedAuthor2).isEqualTo(testAuthor2);
    }
}