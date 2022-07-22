package com.example.demoapi.services;


import org.springframework.security.core.userdetails.UserDetails;

public interface AccountService {
    UserDetails getById(Long id);
}
