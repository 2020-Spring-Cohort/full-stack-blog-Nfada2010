package org.wcci.blog;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.DirtiesContext;
import org.wcci.blog.Model.Category;
import org.wcci.blog.Model.Post;
import org.wcci.blog.Model.Tag;
import org.wcci.blog.Storage.Repos.CategoryRepository;
import org.wcci.blog.Storage.Repos.PostRepository;
import org.wcci.blog.Storage.Repos.TagRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DirtiesContext
@ComponentScan
@DataJpaTest
public class JpaWiringTest {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void categoryShouldHaveListofPosts(){
        Category testCategory = new Category();
        Post testPost = new Post();
        Tag testTag = new Tag();

        categoryRepository.save(testCategory);
        postRepository.save(testPost);
        tagRepository.save(testTag);
        entityManager.flush();
        entityManager.clear();

        Optional<Category> retrievedCategoriesOptional = categoryRepository.findById(testCategory.getId());
        Category retrievedCategory = retrievedCategoriesOptional.get();

        Optional<Post> retreivedPostsOptional = postRepository.findById(testPost.getId());
        Post retrievedPost = retreivedPostsOptional.get();

        Optional<Tag> retrievedTagsOptional = tagRepository.findByTitle(testTag.getTitle());
        Tag retreivedTag = retrievedTagsOptional.get();

        assertThat(retrievedCategory.getPost()).contains(testPost);


    }
}
