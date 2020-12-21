package com.example.spring5mvcrest.services;

import com.example.spring5mvcrest.api.v1.mapper.CategoryMapper;
import com.example.spring5mvcrest.api.v1.model.CategoryDTO;
import com.example.spring5mvcrest.domain.Category;
import com.example.spring5mvcrest.repositories.CategoryRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CategoryServiceTest {
    public static final Long ID=2L;
    public static final String NAME="jimmy";
    CategoryService categoryService;
    @Mock
    CategoryRepository categoryRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        categoryService=new CategoryServiceImp(CategoryMapper.INSTANCE,categoryRepository);
    }

    @Test
    void getAllCategories() {
        List<Category> categoryList= Arrays.asList(new Category(),new Category(),new Category());
        when(categoryRepository.findAll()).thenReturn(categoryList);
        List<CategoryDTO> categoryDTOS= (List<CategoryDTO>) categoryService.getAllCategories();
        assertEquals(3,categoryDTOS.size());
    }

    @Test
    void getCategoryByName() {
        Category category=new Category();
        category.setId(ID);
        category.setName(NAME);
        String name = null;
        when(categoryRepository.findByName(name)).thenReturn(category);
        CategoryDTO categoryDTO=categoryService.getCategoryByName(NAME);
        assertEquals(ID,categoryDTO.getId());
        assertEquals(NAME,categoryDTO.getName());
    }
}