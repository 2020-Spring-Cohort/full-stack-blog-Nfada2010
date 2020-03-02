package org.wcci.blog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.blog.Model.Author;
import org.wcci.blog.Model.Category;
import org.wcci.blog.Model.Post;
import org.wcci.blog.Storage.Repos.*;
@Controller
public class PostController {
    private PostStorage postStorage;
    private TagStorage tagStorage;
    private CategoryStorage categoryStorage;
    private AuthorStorage authorStorage;

    public PostController(PostStorage postStorage, TagStorage tagStorage, CategoryStorage categoryStorage, AuthorStorage authorStorage) {
        this.postStorage = postStorage;
        this.tagStorage = tagStorage;
        this.categoryStorage = categoryStorage;
        this.authorStorage = authorStorage;
    }

    @RequestMapping("/postPage/{id}")
    public String displaySinglePost(@PathVariable Long id, Model model) {
        Post retrievedPost = postStorage.findPostById(id);
        model.addAttribute("post", retrievedPost);
        return "postPageTemplate";
    }

    @PostMapping("add")
    public String addPost(@RequestParam("author")String author,@RequestParam("category")String category),@RequestParam("title") String title, @RequestParam("bodyTest") String bodtText) {
        Author testAuthor = new Author();
        Post testPost = new Post();
        Category testCategory = categoryStorage.findCategoryById(id).get();
        postStorage.store(new Post("title", "bodyText", testAuthor,testPost) {
        return"redirect:/categoryPage/"+category.getName(name);}


    }

    @GetMapping("all-posts")
    public String viewAllPosts(Model model){
        model.addAttribute("Authors",authorStorage.getAll());
        model.addAttribute("Categories",categoryStorage.getAll());
        model.addAttribute("Tags",tagStorage.getAll());
        return "posts";
    }
}
