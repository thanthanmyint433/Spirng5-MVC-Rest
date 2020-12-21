package com.example.spring5mvcrest.controller.v1;

import com.example.spring5mvcrest.api.v1.model.CategoryDTO;
import com.example.spring5mvcrest.services.CategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.when;

public class CategoryControllerTest {
    public static final String NAME="ttm";
    @Mock
    CategoryService categoryService;

    @InjectMocks
    CategoryController categoryController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testListCategories() throws Exception{
        CategoryDTO categoryDTO=new CategoryDTO();
        categoryDTO.setId(1L);
        categoryDTO.setName(NAME);
        CategoryDTO categoryDTO1=new CategoryDTO();
        categoryDTO.setId(2L);
        categoryDTO.setName("Bobs");
        List<CategoryDTO> categoryDTOS= Arrays.asList(categoryDTO,categoryDTO1);
        when(categoryService.getAllCategories()).thenReturn(categoryDTOS);
//        mockMvc.perform(get("api/v1/categories")
////        .contentType(MediaType.APPLICATION_JSON)
//        .andExpect(status().isOk())
//        .andExpect(jsonPath("$.categories"),hasSize()));
    }

    private MockHttpServletRequestBuilder get(String s) {
        return null;
    }

    private Object hasSize() {
        return null;

    }

    private Object jsonPath(String s) {
        return null;
    }

    private StatusResultMatchers status() {
        return null;
    }


}