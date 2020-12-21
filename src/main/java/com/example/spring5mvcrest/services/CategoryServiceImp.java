package com.example.spring5mvcrest.services;

import com.example.spring5mvcrest.api.v1.mapper.CategoryMapper;
import com.example.spring5mvcrest.api.v1.model.CategoryDTO;
import com.example.spring5mvcrest.repositories.CategoryRepository;


import java.util.List;

public class CategoryServiceImp implements CategoryService{
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImp(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return (List<CategoryDTO>) categoryRepository.findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDTO);
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return categoryMapper.categoryToCategoryDTO(categoryRepository.findByName(name));
    }
}
