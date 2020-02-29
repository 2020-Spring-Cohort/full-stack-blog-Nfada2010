package org.wcci.blog.Model;

import java.util.Objects;

public class Category {

    private String name;
    private Post post;
    private String categoryGenre;

    public String getCategryGenre() {
        return categoryGenre;
    }

    public Category(String name, Post post, String categryGenre) {
        this.name = name;
        this.post = post;
        this.categoryGenre = categoryGenre;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public Post getPost() {
        return post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(post, category.post) &&
                Objects.equals(categoryGenre, category.categoryGenre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, post, categoryGenre);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", post=" + post +
                ", categoryGenre='" + categoryGenre + '\'' +
                '}';
    }
}

