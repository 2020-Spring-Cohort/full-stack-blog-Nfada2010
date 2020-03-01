package org.wcci.blog.Storage.Repos;

import org.wcci.blog.Model.Tag;

import java.util.Collection;

public interface TagStorage {
    Collection<Tag> getAll();

    void store (Tag tag);

    Tag findTagByTitle(String title);

    Tag findTagById(long id);
}
