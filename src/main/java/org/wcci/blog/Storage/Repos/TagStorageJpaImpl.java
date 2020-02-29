package org.wcci.blog.Storage.Repos;

import org.springframework.stereotype.Service;
import org.wcci.blog.Model.Author;
import org.wcci.blog.Model.Tag;

@Service
public class TagStorageJpaImpl implements TagStorage {

    private TagRepository tagRepository;

    public TagStorageJpaImpl(TagRepository tagRepository){
        this.tagRepository = tagRepository;
    }

    @Override
    public void store(Tag tag){

    }

    @Override
    public Tag findTagbyAuthor(Author author){
        return tagRepository.findByAuthor(author).get();
    }

}
