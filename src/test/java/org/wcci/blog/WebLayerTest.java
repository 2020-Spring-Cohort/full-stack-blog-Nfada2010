package org.wcci.blog;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.wcci.blog.Storage.Repos.CategoryStorage;
import org.wcci.blog.Storage.Repos.PostStorage;
import org.wcci.blog.Storage.Repos.TagStorage;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@DirtiesContext
@WebMvcTest
public class WebLayerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    CategoryStorage mockStorage;
    @MockBean
    PostStorage mockStorage2;
    @MockBean
    TagStorage mockStorage3;


    @Test
    public void categoriesShouldBeOkAndReturnTheCategoriesViewAndModelsAttribute() throws Exception {
        mockMvc.perform(get("/category"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("categoriesView"))
                .andExpect(model().attributeExists("category"));
    }




    @Test
    public void postsShouldBeOkAndReturnThePostViewWithPostsModelAttribute() throws Exception {
        mockMvc.perform(get("/post/all-posts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("posts"))
                .andExpect(model().attributeExists("posts"));
    }

    @Test
    public void authorsShouldBeOkAndReturnTheAuthorViewWithAuthorsModelAttribute() throws Exception {
        mockMvc.perform(get("/author/all-authors"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("authors"))
                .andExpect(model().attributeExists("authors"));
    }

    @Test
    public void categoriesShouldBeOkAndReturnTheCategoryViewWithCategoriesModelAttribute() throws Exception {
        mockMvc.perform(get("/category/all-categories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("categories"))
                .andExpect(model().attributeExists("categories"));
    }

    @Test
    public void tagsShouldBeOkAndReturnTheTagViewWithTagsModelAttribute() throws Exception {
        mockMvc.perform(get("/tag/all-tags"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("tags"))
                .andExpect(model().attributeExists("tags"));
    }

}
