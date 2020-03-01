package org.wcci.blog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.Model.Category;
import org.wcci.blog.Storage.Repos.CategoryStorage;

@Controller
public class CategoryController {

    private CategoryStorage categoryStorage;

    public CategoryController(CategoryStorage categoryStorage){this.categoryStorage = categoryStorage;}

    @RequestMapping("/category")
    public String displayCategories(Model model){
        model.addAttribute("categories", categoryStorage.getAll());
        return "categoriesView";
    }

    @RequestMapping("/category/{categoryGenre}")
    public String displaySingleCategory(@PathVariable String categoryGenre, Model model) {
        Category retrievedCategory = categoryStorage.findCategoryByGenre(categoryGenre);
        model.addAttribute("category", retrievedCategory);
        return "categoryPage";
    }
}
