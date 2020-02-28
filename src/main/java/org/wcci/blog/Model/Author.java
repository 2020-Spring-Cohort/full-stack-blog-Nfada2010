package org.wcci.blog.Model;

import java.util.Objects;

public class Author {

    private String name;
    private Post post;

    public Author(String name, Post post) {
        this.name = name;
        this.post = post;
    }

    public Author(){}

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
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
                Objects.equals(post, author.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, post);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", post=" + post +
                '}';
    }
}
