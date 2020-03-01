package org.wcci.blog.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String authorName;
    @OneToMany
    private Collection<Post> post;

    public Author(String authorName, Post post) {
        this.authorName = authorName;
        this.post = Arrays.asList(post);
    }

    public Author(){}

    public String getAuthorName() {
        return authorName;
    }

    public Post getPost() {
        return (Post) post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(authorName, author.authorName) &&
                Objects.equals(post, author.post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorName, post);
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + authorName + '\'' +
                ", post=" + post +
                '}';
    }
}
