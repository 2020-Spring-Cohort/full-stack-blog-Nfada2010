package org.wcci.blog.Storage.Repos;

import org.wcci.blog.Model.Category;

import java.util.Collection;

public interface CategoryStorage {
    Collection <Category> getAll();

    void store (Category category);


Category findCategoryByName(String categoryName);
    Category findCategoryById(long id);


}
