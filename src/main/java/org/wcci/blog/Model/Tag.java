package org.wcci.blog.Model;

import java.util.Objects;

public class Tag {

    private String name;
    private Post post;
    private String title;

    public Tag(String name, Post post,String title) {
        this.name = name;
        this.post = post;
        this.title = title;
    }

    public Tag(){}

    public String getName() {
        return name;
    }

    public Post getPost() {
        return post;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(name, tag.name) &&
                Objects.equals(post, tag.post) &&
                Objects.equals(title, tag.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, post, title);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "name='" + name + '\'' +
                ", post=" + post +
                ", title='" + title + '\'' +
                '}';
    }
}