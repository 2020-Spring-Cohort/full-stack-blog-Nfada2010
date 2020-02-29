package org.wcci.blog.Storage.Repos;


import org.springframework.data.repository.CrudRepository;
import org.wcci.blog.Model.Category;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {


    Optional<Category> findByGenre(String categoryGenre);
}
