package org.wcci.blog.Model;

import java.util.Objects;

public class Tag {

    private String name;
    private Post post;

    public Tag(String name, Post post) {
        this.name = name;
        this.post = post;
    }

    public Tag(){}

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
        Tag tag = (Tag) o;
        return Objects.equals(name, tag.name) &&
                Objects.equals(post, tag.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, post);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                ", post=" + post +
                '}';
    }
}
