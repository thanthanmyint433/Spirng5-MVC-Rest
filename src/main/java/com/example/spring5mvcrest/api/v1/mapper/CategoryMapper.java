package com.example.spring5mvcrest.api.v1.mapper;


import com.example.spring5mvcrest.domain.Category;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = null;

    <R> R categoryToCategoryDTO(Category category);
}
