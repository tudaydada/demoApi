package com.example.demoapi.services;


import com.example.demoapi.form.RegisterForm;
import com.example.demoapi.model.response.AccountResponse;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface AccountService {
    UserDetails getById(Long id);
    List<AccountResponse> getAll();
    UserDetails register(RegisterForm registerForm);
}
