package org.wcci.blog.Model;

import java.util.Date;
import java.util.Objects;

public class Post {

    private String title;
    private String bodyText;
    private Author author;
    private Date date;

    public Post() {}

    public Post(String title, String bodyText, Author author, Date date) {
        this.title = title;
        this.bodyText = bodyText;
        this.author = author;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getBodyText() {
        return bodyText;
    }

    public Author getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) &&
                Objects.equals(bodyText, post.bodyText) &&
                Objects.equals(author, post.author) &&
                Objects.equals(date, post.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, bodyText, author, date);
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", bodyText='" + bodyText + '\'' +
                ", author=" + author +
                ", date=" + date +
                '}';
    }
}


