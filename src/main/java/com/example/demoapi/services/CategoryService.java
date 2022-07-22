package com.example.demoapi.services;

import com.example.demoapi.model.Category;
import com.example.demoapi.model.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAll();
}
