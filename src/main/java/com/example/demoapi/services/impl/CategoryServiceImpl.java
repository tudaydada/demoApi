package com.example.demoapi.services.impl;

import com.example.demoapi.model.Category;
import com.example.demoapi.model.response.CategoryResponse;
import com.example.demoapi.repository.CategoryRepository;
import com.example.demoapi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<CategoryResponse> getAll() {
        return ToCategoryResponses(categoryRepository.findAll());
    }
    private CategoryResponse ToCategoryResponse(Category category){
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategoryId(category.getCategoryId());
        categoryResponse.setName(category.getName());
        categoryResponse.setDescriptions(category.getDescriptions());
        return categoryResponse;
    }
    private List<CategoryResponse> ToCategoryResponses(List<Category> categoryList){
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (Category category: categoryList){
            categoryResponses.add(ToCategoryResponse(category));
        }
        return categoryResponses;
    }
}
