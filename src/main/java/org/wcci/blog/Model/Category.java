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
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private Collection<Post> post;

//    private String categoryGenre;


//    public String getCategryGenre() {
//        return categoryGenre;
//    }

    public Category(String categoryName, Post post, long id) {
        this.categoryName = categoryName;
        this.post = Arrays.asList(post);
//        this.categoryGenre = categoryGenre;
        this.id = id;
    }

    public Category() {
    }

//    public String getCategoryGenre() {
//        return categoryGenre;
//    }

    public String getCategoryName() {
        return categoryName;
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
        return Objects.equals(categoryName, category.categoryName) &&
                Objects.equals(post, category.post);
//                &&
//                Objects.equals(categoryGenre, category.categoryGenre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName, post);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + categoryName + '\'' +
                ", post=" + post +
                ", categoryGenre='" +  '\'' +
                '}';
    }
}

