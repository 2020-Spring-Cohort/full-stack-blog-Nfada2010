package org.wcci.blog.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
@Entity
public class Post {
@Id
@GeneratedValue
    private Long id;
    private String title;
    private String bodyText;
    @ManyToOne
    private Author author;
    private Date date;
    @ManyToMany(mappedBy = "post")
    private Collection<Tag> tag;
    @ManyToOne
    private Category category;


    public Post() {}

    public Post(String title, String bodyText, Author author, long id) {
        this.title = title;
        this.bodyText = bodyText;
        this.author = author;
        this.id = id;

//        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getBodyText() {
        return bodyText;
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }
    public Author getAuthor() {
        return author;
    }
//    public Date getDate() {

//        return date;

//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) &&
                Objects.equals(bodyText, post.bodyText) &&
                Objects.equals(author, post.author) ;
//                Objects.equals(date, post.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, bodyText, author );
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", bodyText='" + bodyText + '\'' +
                ", author=" + author +
//                ", date=" + date +
                '}';
    }
}


