package com.bayyand.spring_app.domain.service;

import com.bayyand.spring_app.common.dto.CategoryDto;
import com.bayyand.spring_app.domain.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategories();
    Category findCategoryById(Short id);
    Category createCategory(CategoryDto categoryDto);
    Category updateCategory(CategoryDto categoryDto);
    void deleteCategoryById(Short id);
}
