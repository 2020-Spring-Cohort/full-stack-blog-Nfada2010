package org.wcci.blog.Storage.Repos;

import org.springframework.stereotype.Service;
import org.wcci.blog.Model.Category;

import java.util.Collection;

@Service
public class CategoryStorageJpaImpl implements CategoryStorage {

   private CategoryRepository categoryRepository;

    public CategoryStorageJpaImpl(CategoryRepository categoryRepository)
    {this.categoryRepository = categoryRepository;
    }

    @Override
    public Collection<Category> getAll() {
        return (Collection<Category>)categoryRepository.findAll();
    }

    @Override
    public void store(Category category) {
        categoryRepository.save(category);

    }

    @Override
    public Category findCategoryByGenre(String categoryGenre) {
        return categoryRepository.findByGenre(categoryGenre).get();}

    @Override
    public Category findCategoryById(long id) {
        return categoryRepository.findById(id).get();
    }

}

