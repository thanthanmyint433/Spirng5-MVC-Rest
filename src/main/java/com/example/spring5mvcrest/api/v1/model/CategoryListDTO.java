package com.example.spring5mvcrest.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoryListDTO {
    List<CategoryDTO> categoryDTO;

    public CategoryListDTO(List<CategoryDTO> categoryDTO) {
        this.categoryDTO = categoryDTO;
    }
}
