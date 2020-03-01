package org.wcci.blog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wcci.blog.Model.Tag;
import org.wcci.blog.Storage.Repos.PostStorage;
import org.wcci.blog.Storage.Repos.TagStorage;
@Controller

public class TagController {

    private TagStorage tagStorage;
    private PostStorage postStorage;

    public TagController(TagStorage tagStorage, PostStorage postStorage) {
        this.tagStorage = tagStorage;
        this.postStorage = postStorage;
    }

    @RequestMapping("/tagPage/{title}")
    public  String displayOneTag(@PathVariable String title, Model model){
        Tag retrievedTag = tagStorage.findTagByTitle(title);
        model.addAttribute("tag",retrievedTag);
        return "tagView";
    }
}
