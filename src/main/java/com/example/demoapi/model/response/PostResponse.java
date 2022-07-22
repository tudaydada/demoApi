package com.example.demoapi.model.response;

import com.example.demoapi.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Long postId;
    private String title;
    private String descriptions;
    private List<CommentResponse> comments;
    private CategoryResponse category;
    private StatusResponse status;
}
