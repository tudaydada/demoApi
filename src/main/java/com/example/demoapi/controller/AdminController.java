package com.example.demoapi.controller;

import com.example.demoapi.model.response.*;
import com.example.demoapi.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AccountService accountService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    CommentService commentService;
    @Autowired
    PostService postService;
    @Autowired
    StatusService statusService;

    @GetMapping("/accounts")
    public List<AccountResponse> accountResponses(){
        List<AccountResponse> accountResponses = new ArrayList<>();
        accountResponses.addAll(accountService.getAll());
        return accountResponses;
    }

    @GetMapping("/categories")
    public List<CategoryResponse> categoryResponses(){
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        categoryResponses.addAll(categoryService.getAll());
        return categoryResponses;
    }

    @GetMapping("/comments")
    public List<CommentResponse> commentResponses(){
        List<CommentResponse> commentResponses = new ArrayList<>();
        commentResponses.addAll(commentService.getAll(0));
        return commentResponses;
    }

    @GetMapping("/posts")
    public List<PostResponse> postResponses(){
        List<PostResponse> postResponses = new ArrayList<>();
        postResponses.addAll(postService.getAll(0));
        return postResponses;
    }

    @GetMapping("/status")
    public List<StatusResponse> statusResponses(){
        List<StatusResponse> statusResponses = new ArrayList<>();
        statusResponses.addAll(statusService.getAll());
        return statusResponses;
    }

}
