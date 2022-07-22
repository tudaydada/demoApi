package com.example.demoapi.repository;

import com.example.demoapi.model.Category;
import com.example.demoapi.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
