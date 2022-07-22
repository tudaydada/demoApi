package com.example.demoapi.services;

import com.example.demoapi.model.response.CommentResponse;

import java.util.List;

public interface CommentService {
    List<CommentResponse> getAll(int page);
    List<CommentResponse> getByMessages(String messages);
}
