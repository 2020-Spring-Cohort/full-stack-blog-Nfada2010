package org.wcci.blog.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category")
    private Collection<Post> post;

//    private String categoryGenre;


//    public String getCategryGenre() {
//        return categoryGenre;
//    }

    public Category(String name, Post post, long id) {
        this.name = name;
        this.post = Arrays.asList(post);
//        this.categoryGenre = categoryGenre;
        this.id = id;
    }

    public Category() {
    }

//    public String getCategoryGenre() {
//        return categoryGenre;
//    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Post getPost() {
        return (Post) post;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(post, category.post);
//                &&
//                Objects.equals(categoryGenre, category.categoryGenre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, post);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", post=" + post +
                ", categoryGenre='" +  '\'' +
                '}';
    }
}

