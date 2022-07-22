package com.example.demoapi.controller;

import com.example.demoapi.form.PostForm;
import com.example.demoapi.model.response.PostResponse;
import com.example.demoapi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;



    @PostMapping("")
    public String createPost(@RequestBody PostForm postForm) {

        return postService.create(postForm);
    }
    @GetMapping("/{id}")
    public PostResponse getPostById(@PathVariable(value = "id", required = false) Long postId) {
        PostResponse postResponse = postService.getById(postId);
        return postResponse!=null?postResponse:new PostResponse();
    }

    @PutMapping("/{id}")
    public String updatePost(@RequestBody PostForm postForm, @PathVariable Long id) {
        postForm.setId(id);
        return postService.update(postForm);
    }
    @DeleteMapping("/{id}")
    public String deletePostById(@PathVariable("id") Long postId) {
        if (postId == null) return "null variable";
        return postService.delete(postId);
    }

    @GetMapping("")
    public List<PostResponse> getPostByTitle(@RequestParam(value = "title", required = false) String title,
                                             @RequestParam(value = "statusId", required = false,defaultValue = "0") Long statusId,
                                             @RequestParam(value = "categoryId", required = false,defaultValue = "0") Long categoryId,
                                             @RequestParam(value = "page",required = false,defaultValue = "0") int page) {
        List<PostResponse> postResponses = new ArrayList<>();

        if (title != null) postResponses.addAll(postService.getByTitle(title)) ;
        if (statusId>0) postResponses.addAll(postService.getByStatus(statusId));
        if (categoryId>0) postResponses.addAll(postService.getByCategory(categoryId));
        if (postResponses.isEmpty()) postResponses = postService.getAll(page);
        return postResponses;
    }

}
