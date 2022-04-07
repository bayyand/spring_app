package com.bayyand.spring_app.persistence.repository;

import com.bayyand.spring_app.domain.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Short> {
    Category findCategoryById(Short id);
    Boolean existsByName(String name);
}
