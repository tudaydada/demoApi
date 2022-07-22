package com.example.demoapi.controller;

import com.example.demoapi.model.response.CommentResponse;
import com.example.demoapi.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping("")
    public List<CommentResponse> comments(@RequestParam(required = false, name = "page", defaultValue = "0") int page,
                                          @RequestParam(required = false, name = "messages", defaultValue = "") String messages) {
        List<CommentResponse> commentResponses = new ArrayList<>();
        commentResponses = commentService.getAll(page);
        if (messages.length()>0)
            commentResponses.addAll(commentService.getByMessages(messages));
        return commentResponses;
    }
}
