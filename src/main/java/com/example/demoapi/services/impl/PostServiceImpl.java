package com.example.demoapi.services.impl;

import com.example.demoapi.form.PostForm;
import com.example.demoapi.model.Category;
import com.example.demoapi.model.Comment;
import com.example.demoapi.model.Post;
import com.example.demoapi.model.Status;
import com.example.demoapi.model.response.CategoryResponse;
import com.example.demoapi.model.response.CommentResponse;
import com.example.demoapi.model.response.PostResponse;
import com.example.demoapi.model.response.StatusResponse;
import com.example.demoapi.repository.PostRepository;
import com.example.demoapi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;


    @Override
    public List<PostResponse> getAll(int page) {
        if (page==0)
            return ToPostResponse(postRepository.findAll());
        else
            return ToPostResponse(postRepository.findAll(PageRequest.of(page-1,3)).getContent());
    }

    @Override
    public List<PostResponse> getByTitle(String title) {
        return ToPostResponse(postRepository.findByTitle(title));
    }

    @Override
    public PostResponse getById(Long id) {
        Post post = postRepository.findByPostId(id);
        if (post== null) return null;
        return ToPostResponse(post);
    }

    @Override
    public List<PostResponse> getByStatus(Long statusId) {
        List<Post> posts = postRepository.findByStatusStatusId(statusId);
        if (posts== null || posts.size()<1) return null;
        return ToPostResponse(posts);
    }

    @Override
    public List<PostResponse> getByCategory(Long categoryId) {
        List<Post> posts = postRepository.findByCategory_CategoryId(categoryId);
        if (posts== null || posts.size()<1) return null;
        return ToPostResponse(posts);
    }

    @Override
    public String create(PostForm postForm) {
        Post post = new Post();
        post.setStatus(new Status(1L));
        post.setCategory(new Category(postForm.getCategoryId()));
        post.setTitle(postForm.getTitle());
        post.setDescriptions(postForm.getDescriptions());
        Date date = new Date();
        post.setCreateDate(date);
        post.setUpdateDate(date);
        if (postRepository.save(post)!=null)
            return "success";
        return "failed";
    }

    @Override
    public String update(PostForm postForm) {
        Post post = postRepository.findByPostId(postForm.getId());
        if (post==null) return "failed";
        if (postForm.getTitle()!=null)
            post.setTitle(postForm.getTitle());
        if (postForm.getDescriptions()!=null)
            post.setDescriptions(postForm.getDescriptions());
        if (postForm.getCategoryId()!=null)
            post.setCategory(new Category(postForm.getCategoryId()));
        post.setStatus(new Status(1L));
        post.setUpdateDate(new Date());
        postRepository.save(post);
        return "success";
    }

    @Override
    public String delete(Long id) {
        Post post = postRepository.findByPostId(id);
        if (post== null) return "failed";
        post.setStatus(new Status(1L));
        postRepository.save(post);
        return "success";
    }

    private PostResponse ToPostResponse(Post post){
        PostResponse postResponse = new PostResponse();
        postResponse.setPostId(post.getPostId());
        postResponse.setTitle(post.getTitle());
        postResponse.setDescriptions(post.getDescriptions());
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setCategoryId(post.getCategory().getCategoryId());
        categoryResponse.setName(post.getCategory().getName());
        postResponse.setCategory(categoryResponse);
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setStatusId(post.getStatus().getStatusId());
        statusResponse.setName(post.getStatus().getName());
        postResponse.setStatus(statusResponse);
        List<CommentResponse> commentResponses = new ArrayList<>();
        for (Comment comment: post.getComments()){
            CommentResponse commentResponse = new CommentResponse();
            commentResponse.setMessages(comment.getMessages());
            commentResponses.add(commentResponse);
        }
        postResponse.setComments(commentResponses);
        return postResponse;
    }
    private List<PostResponse> ToPostResponse(List<Post> posts){
        List<PostResponse> postResponses = new ArrayList<>();
        for (Post post: posts){
            postResponses.add(ToPostResponse(post));
        }
        return  postResponses;
    }
}
