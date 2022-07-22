package com.example.demoapi.repository;

import com.example.demoapi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    Post findByPostId(Long id);
    List<Post> findByStatusStatusId(Long statusId);
    List<Post> findByCategory_CategoryId(Long categoryId);
    @Query("select p from Post as p where p.title like %?1% order by p.title desc")
    List<Post> findByTitle(String title) ;
}
