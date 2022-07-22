package com.example.demoapi.services;

import com.example.demoapi.form.PostForm;
import com.example.demoapi.model.response.PostResponse;

import java.util.List;

public interface PostService {
    List<PostResponse> getAll(int page);
    List<PostResponse> getByTitle(String title);
    PostResponse getById(Long id);
    List<PostResponse> getByStatus(Long statusId);
    List<PostResponse> getByCategory(Long categoryId);
    String create(PostForm postForm);
    String update(PostForm postForm);
    String delete(Long id);
}
