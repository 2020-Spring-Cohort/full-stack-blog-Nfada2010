package org.wcci.blog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.wcci.blog.Controller.PostController;
import org.wcci.blog.Model.Author;
import org.wcci.blog.Model.Category;
import org.wcci.blog.Model.Post;
import org.wcci.blog.Storage.Repos.AuthorStorage;
import org.wcci.blog.Storage.Repos.CategoryStorage;
import org.wcci.blog.Storage.Repos.PostStorage;
import org.wcci.blog.Storage.Repos.TagStorage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PostControllerTest {

    private PostController underTest;
    private Model model;
    private PostStorage mockPostStorage;
    private Post testPost;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockPostStorage = mock(PostStorage.class);
        CategoryStorage mockCategoryStorage = mock(CategoryStorage.class);
        TagStorage mockTagStorage = mock(TagStorage.class);
        AuthorStorage mockAuthorStorage = mock(AuthorStorage.class);
        underTest = new PostController(mockPostStorage, mockAuthorStorage, mockCategoryStorage, mockTagStorage);
        mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();
        model = mock(Model.class);
        Author testAuthor = new Author("user");
        Category testCategory = new Category("water");
        testPost = new Post("test", "test");
        when(mockCategoryStorage.findCategoryByName("water")).thenReturn(testCategory);
        when(mockPostStorage.findPostById(1L)).thenReturn(testPost);
    }

//    @Test
//    public void displayPostReturnsPostTemplate() {
//        String result = underTest.displayPostFromAuthorPage((long) 1, model);
//        assertThat(result).isEqualTo("post");
//
//    }
//
//    @Test
//    public void displayPostInteractsWithDependenciesCorrectly() {
//        underTest.displayPostFromAuthorPage((long) 1, model);
//        verify(mockPostStorage).findPostById(1L);
//        verify(model).addAttribute("post", testPost);
//
//
//    }

    @Test
    public void displayPostMappingIsCorrect() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(underTest).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/post/single-post/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("post"))
                .andExpect(model().attributeExists("post"))
                .andExpect(model().attribute("post", testPost));
    }

    @Test
    public void addPostShouldRedirect() throws Exception {
        mockMvc.perform(post("/post/add")
                .param("author", "user")
                .param("category", "water")
                .param("postTitle", "test")
                .param("postBody", "test"))
                .andExpect(status().is3xxRedirection());


        Author testAuthor = new Author();
        long id = 1;
        verify(mockPostStorage).store(new Post("user", "water", testAuthor, id));
    }
}
