package org.wcci.blog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.wcci.blog.Model.Author;
import org.wcci.blog.Storage.Repos.AuthorStorage;
import org.wcci.blog.Storage.Repos.PostStorage;

@Controller
@RequestMapping
public class AuthorController {

    private AuthorStorage authorStorage;
    private PostStorage postStorage;

    public AuthorController(AuthorStorage authorStorage) {
        this.authorStorage = authorStorage;
    }

    @GetMapping("/{authorId}")
    public String displayAuthorFromPostPage(@PathVariable long authorId, Model model) {
        Author retrievedAuthor = authorStorage.findAuthorById(authorId);
        model.addAttribute("author", retrievedAuthor);
        return "author";
    }

    @PostMapping("add")
    public String AddAuthorForm(@RequestParam String authorName) {
        authorStorage.store(new Author(authorName));
        return "redirect:/author/all-authors";
    }

    @GetMapping("all-authors")
    public String viewAllAuthors(Model model) {
        model.addAttribute("authors", authorStorage.getAll());
        return "authors";

    }
}
