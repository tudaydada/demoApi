package com.example.demoapi.services;


import com.example.demoapi.form.RegisterForm;
import com.example.demoapi.model.response.AccountResponse;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface AccountService {
    UserDetails loadById(Long id);
    AccountResponse getById(Long id);
    List<AccountResponse> getAll();
    AccountResponse register(RegisterForm registerForm);
}
