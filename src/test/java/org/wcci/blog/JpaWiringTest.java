package org.wcci.blog;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.wcci.blog.Model.Author;
import org.wcci.blog.Model.Category;
import org.wcci.blog.Model.Post;
import org.wcci.blog.Model.Tag;
import org.wcci.blog.Storage.Repos.AuthorRepository;
import org.wcci.blog.Storage.Repos.CategoryRepository;
import org.wcci.blog.Storage.Repos.PostRepository;
import org.wcci.blog.Storage.Repos.TagRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DirtiesContext
@DataJpaTest
public class JpaWiringTest {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void categoryShouldHaveListofPosts() {
        Category testCategory = new Category();
        Post testPost = new Post();
        Tag testTag = new Tag();
        Author testAuthor = new Author();

        categoryRepository.save(testCategory);
        postRepository.save(testPost);
        tagRepository.save(testTag);
        authorRepository.save(testAuthor);

        entityManager.flush();
        entityManager.clear();

        Optional<Category> retrievedCategoriesOptional = categoryRepository.findById(testCategory.getId());
        Category retrievedCategory = retrievedCategoriesOptional.get();




        Optional<Post> retreivedPostsOptional = postRepository.findById(testPost.getId());
        Post retrievedPost = retreivedPostsOptional.get();

        Optional<Tag> retrievedTagsOptional = tagRepository.findByTitle(testTag.getTitle());
        Tag retreivedTag = retrievedTagsOptional.get();

        Optional<Author> retrievedAuthorOptional = authorRepository.findByAuthorName(testAuthor.getAuthorName());
        Author retrievedAuthor = retrievedAuthorOptional.get();


//        assertThat(retrievedCategory.getPost().contains(testPost));
//        assertThat(retrievedPost.getAuthor().contains(testAuthor));



    }
}
