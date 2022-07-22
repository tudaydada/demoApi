package com.example.demoapi.repository;

import com.example.demoapi.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {
    Status findByStatusId(Long id);
}
