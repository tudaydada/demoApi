package com.example.demoapi.repository;

import com.example.demoapi.model.status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface statusRepository  extends JpaRepository<status,Long> {
    status findByStatusId(Long id);
}
