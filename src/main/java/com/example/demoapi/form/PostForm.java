package com.example.demoapi.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostForm {
    private Long id;
    private String title;
    private String descriptions;
    private Long categoryId;
}
