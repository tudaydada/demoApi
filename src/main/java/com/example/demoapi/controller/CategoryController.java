package com.example.demoapi.controller;

import com.example.demoapi.model.response.CategoryResponse;
import com.example.demoapi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public List<CategoryResponse> categories() {
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        categoryResponses = categoryService.getAll();
        return categoryResponses;
    }
}
