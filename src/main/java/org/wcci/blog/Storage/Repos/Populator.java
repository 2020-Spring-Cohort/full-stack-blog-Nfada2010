package org.wcci.blog.Storage.Repos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.blog.Model.Author;
import org.wcci.blog.Model.Category;
import org.wcci.blog.Model.Post;
import org.wcci.blog.Model.Tag;

@Component
public class Populator implements CommandLineRunner {
    private CategoryStorageJpaImpl categoryStorageJpa;
    private TagStorageJpaImpl tagStorageJpa;
    private PostStorageJpaImpl postStorageJpa;
    private AuthorStorageJpaImpl authorStorageJpa;

    public Populator(CategoryStorage categoryStorage, TagStorage tagStorage, PostStorageJpaImpl postStorageJpa,AuthorStorageJpaImpl authorStorageJpa){
        this.categoryStorageJpa = (CategoryStorageJpaImpl) categoryStorage;
        this.tagStorageJpa = (TagStorageJpaImpl) tagStorage;
        this.postStorageJpa = postStorageJpa;
        this.authorStorageJpa= authorStorageJpa;
    }




    @Override
    public void run(String... args)  {
        Category cat1 = new Category();
        categoryStorageJpa.store(cat1);

        Category cat2 = new Category();
        categoryStorageJpa.store(cat2);

        Category cat3 = new Category();
        categoryStorageJpa.store(cat3);

        Category cat4 = new Category();
        categoryStorageJpa.store(cat4);

        Post post1 = new Post();
        postStorageJpa.store(post1);

        Post post2 = new Post();
        postStorageJpa.store(post2);

        Post post3 = new Post();
        postStorageJpa.store(post3);

        Post post4 = new Post();
        postStorageJpa.store(post4);

        Tag tag1 = new Tag();
        tagStorageJpa.store(tag1);

        Tag tag2 = new Tag();
        tagStorageJpa.store(tag2);

        Tag tag3 = new Tag();
        tagStorageJpa.store(tag3);

        Tag tag4 = new Tag();
        tagStorageJpa.store(tag4);

        Author author1 = new Author();
        authorStorageJpa.store(author1);

        Author author2 = new Author();
        authorStorageJpa.store(author2);

        Author author3 = new Author();
        authorStorageJpa.store(author3);

        Author author4 = new Author();
        authorStorageJpa.store(author4);



    }
}
