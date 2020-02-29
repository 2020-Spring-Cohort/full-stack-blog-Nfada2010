package org.wcci.blog.Storage.Repos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.Model.Category;

@Component
public class Populator implements CommandLineRunner {
    private CategoryStorageJpaImpl categoryStorageJpa;
    private TagStorageJpaImpl tagStorageJpa;
    private PostStorageJpaImpl postStorageJpa;

    public Populator(CategoryStorage categoryStorage, TagStorage tagStorage, PostStorageJpaImpl postStorageJpa){
        this.categoryStorageJpa = (CategoryStorageJpaImpl) categoryStorage;
        this.tagStorageJpa = (TagStorageJpaImpl) tagStorage;
        this.postStorageJpa = postStorageJpa;
    }




    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category();
        categoryStorageJpa.store(cat1);

        Category cat2 = new Category();
        categoryStorageJpa.store(cat2);

        Category cat3 = new Category();
        categoryStorageJpa.store(cat3);

        Category cat4 = new Category();
        categoryStorageJpa.store(cat4);


    }
}
