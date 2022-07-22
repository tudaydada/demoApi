package com.example.demoapi.repository;

import com.example.demoapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByAccountId(Long id);
    Account findByUsername(String userName);
}
