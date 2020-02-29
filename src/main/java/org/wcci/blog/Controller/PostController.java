package org.wcci.blog.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wcci.blog.Model.Author;
import org.wcci.blog.Model.Category;
import org.wcci.blog.Model.Post;
import org.wcci.blog.Storage.Repos.CategoryRepository;
import org.wcci.blog.Storage.Repos.PostStorage;
import org.wcci.blog.Storage.Repos.TagRepository;

public class PostController {
    private PostStorage postStorage;
    private TagRepository tagRepository;
    private CategoryRepository categoryRepository;

    public PostController(PostStorage postStorage, TagRepository tagRepository) {
        this.postStorage = postStorage;
        this.tagRepository = tagRepository;
    }

    @RequestMapping("/postPage/{id}")
    public String displaySinglePost(@PathVariable long id, Model model){
        Post retrievedPost = postStorage.findPostbyId(id);
        model.addAttribute("post",retrievedPost);
        return "postPage";
    }

    @PostMapping("/{id}/add-post")
    public String addPost(@PathVariable long id, @RequestParam String postText){
        Author testAuthor = new Author();
        Category category = categoryRepository.findByGenre(categoryGenre).get();
        postStorage.store(new Post("title", "bodyText", testAuthor, date);
        return "redirect:/categoriesView/" + category.getCategryGenre();
    }
}
