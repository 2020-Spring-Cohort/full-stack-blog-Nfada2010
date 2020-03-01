package org.wcci.blog.Storage.Repos;

import org.springframework.stereotype.Service;
import org.wcci.blog.Model.Author;
import org.wcci.blog.Model.Tag;

import java.util.Collection;

@Service
public class TagStorageJpaImpl implements TagStorage {

    private TagRepository tagRepository;

    public TagStorageJpaImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public Collection<Tag> getAll() {
        return (Collection<Tag>)tagRepository.findAll();
    }

    @Override
    public void store(Tag tag) {
        tagRepository.save(tag);

    }

    @Override
    public Tag findTagByTitle(String title) {
        return tagRepository.findByTitle(title).get();
    }

    @Override
    public Tag findTagById(long id){return tagRepository.findById(id).get();}
}

