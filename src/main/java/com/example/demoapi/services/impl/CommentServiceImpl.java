package com.example.demoapi.services.impl;

import com.example.demoapi.model.Comment;
import com.example.demoapi.model.response.CommentResponse;
import com.example.demoapi.model.response.StatusResponse;
import com.example.demoapi.repository.CommentRepository;
import com.example.demoapi.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;
    @Override
    public List<CommentResponse> getAll(int page ) {
        if (page == 0)
            return ToCommentResponses(commentRepository.findAll());
        else
            return ToCommentResponses(commentRepository.findAll(PageRequest.of(page-1,3)).getContent());
    }

    @Override
    public List<CommentResponse> getByMessages(String messages) {
        return ToCommentResponses(commentRepository.findByMessagesContaining(messages));
    }

    private CommentResponse ToCommentResponse(Comment comment){
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setCommentId(comment.getCommentId());
        commentResponse.setMessages(comment.getMessages());
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setName(comment.getStatus().getName());
        commentResponse.setStatus(statusResponse);
        return commentResponse;
    }
    private List<CommentResponse> ToCommentResponses(List<Comment> comments){
        List<CommentResponse> commentResponses = new ArrayList<>();
        for (Comment comment:comments){
            commentResponses.add(ToCommentResponse(comment));
        }
        return commentResponses;
    }
}
