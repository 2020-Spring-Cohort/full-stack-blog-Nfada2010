package org.wcci.blog.Storage.Repos;

import org.wcci.blog.Model.Category;

import java.util.Collection;

public interface CategoryStorage {
    Collection <Category> findAllCategories();

    void store (Category category);

    Category findCategoryByGenre(String categoryGenre);
}
