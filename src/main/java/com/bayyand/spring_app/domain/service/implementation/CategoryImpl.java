package com.bayyand.spring_app.domain.service.implementation;

import com.bayyand.spring_app.common.dto.CategoryDto;
import com.bayyand.spring_app.domain.entity.Category;
import com.bayyand.spring_app.domain.service.CategoryService;
import com.bayyand.spring_app.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    private void categoryExist(String name){
        if(categoryRepository.existsByName(name)){
            throw new DuplicateKeyException("the name of category is already registered");
        }
    }

    @Override
    public List<Category> findAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(Short id) {
        Category category = categoryRepository.findCategoryById(id);
        if(category == null){
            throw new EntityNotFoundException("the category with id " + id + " is not found");
        }
        return category;
    }

    @Override
    public Category createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        this.categoryExist(categoryDto.getName());
        BeanUtils.copyProperties(categoryDto, category);
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(Short id) {
        this.findCategoryById(id);
        categoryRepository.deleteById(id);
    }
}
