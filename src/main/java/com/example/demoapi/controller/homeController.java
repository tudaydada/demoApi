package com.example.demoapi.controller;

import com.example.demoapi.form.LoginForm;
import com.example.demoapi.jwt.JwtTokenProvider;
import com.example.demoapi.model.Account;
import com.example.demoapi.services.CategoryService;
import com.example.demoapi.services.CommentService;
import com.example.demoapi.services.PostService;
import com.example.demoapi.until.CustomUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/home")
public class homeController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;

//    @GetMapping("/categories")
//    public List<CategoryResponse> categories() {
//        List<CategoryResponse> categoryResponses = new ArrayList<>();
//        categoryResponses = categoryService.getAll();
//        return categoryResponses;
//    }
//
//    @GetMapping("/posts")
//    public List<PostResponse> posts(@RequestParam(required = false, name = "page", defaultValue = "0") int page) {
//        List<PostResponse> postResponses = new ArrayList<>();
//
//        postResponses = postService.getAll(page);
//
//        return postResponses;
//    }
//
//    @PostMapping("/posts")
//    public String createPost(@RequestBody PostForm postForm) {
//
//        return postService.create(postForm);
//    }
//
//    @PutMapping("/posts/{id}")
//    public String updatePost(@RequestBody PostForm postForm, @PathVariable Long id) {
//        postForm.setId(id);
//        return postService.update(postForm);
//    }
//
//    @DeleteMapping("/posts/{id}")
//    public String deletePostById(@PathVariable("id") Long postId) {
//        if (postId == null) return "null variable";
//        return postService.delete(postId);
//    }
//
//
//    @GetMapping("/posts/{id}")
//    public PostResponse getPostById(@PathVariable(value = "id", required = false) Long postId) {
//        return postService.getById(postId);
//    }
//
//    @GetMapping("/posts/title={title}")
//    public List<PostResponse> getPostByTitle(@PathVariable(value = "title", required = false) String title) {
//        if (title == null) return new ArrayList<>();
//        return postService.getByTitle(title);
//    }
//
//    @GetMapping("/posts/status={statusId}")
//    public List<PostResponse> getPostByStatusId(@PathVariable(value = "statusId", required = false) Long statusId) {
//        if (statusId == null) return new ArrayList<>();
//        return postService.getByStatus(statusId);
//    }
//
//    @GetMapping("/posts/category={categoryId}")
//    public List<PostResponse> getPostByCategoryId(@PathVariable(value = "categoryId", required = false) Long categoryId) {
//        if (categoryId == null) return new ArrayList<>();
//        return postService.getByCategory(categoryId);
//    }
//
//
//    @GetMapping("/comments")
//    public List<CommentResponse> comments(@RequestParam(required = false, name = "page", defaultValue = "0") int page,
//                                          @RequestParam(required = false, name = "messages", defaultValue = "") String messages) {
//        List<CommentResponse> commentResponses = new ArrayList<>();
//        commentResponses = commentService.getAll(page);
//        if (messages.length()>0)
//            commentResponses.addAll(commentService.getByMessages(messages));
//        return commentResponses;
//    }

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginForm loginForm){


        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginForm.getUsername(),
                        loginForm.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetail customUserDetail = (CustomUserDetail) authentication.getPrincipal();
        Account account = customUserDetail.getAccount();
        String token = jwtTokenProvider.generateToken(customUserDetail);

        return "username:"+account.getUsername()+"/token:"+token;
    }

}
