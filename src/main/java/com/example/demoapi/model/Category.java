package com.example.demoapi.model;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String name;
    private String Descriptions;

    @OneToMany(mappedBy = "category")
    List<Post> posts;

    @ManyToOne
    @JoinColumn(name = "statusId")
    private Status status;

    public Category(Long id)
    {
        this.setCategoryId(id);
    }
}
