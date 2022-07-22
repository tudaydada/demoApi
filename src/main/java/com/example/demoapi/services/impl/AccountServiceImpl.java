package com.example.demoapi.services.impl;

import com.example.demoapi.form.RegisterForm;
import com.example.demoapi.model.Account;
import com.example.demoapi.model.response.AccountResponse;
import com.example.demoapi.repository.AccountRepository;
import com.example.demoapi.services.AccountService;
import com.example.demoapi.until.CustomUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {
    @Autowired
    AccountRepository  accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadById(Long id) {
        Account account = accountRepository.findByAccountId(id);
        if (account==null)
            throw  new UsernameNotFoundException(id.toString());
        return new CustomUserDetail(account);
    }

    @Override
    public AccountResponse getById(Long id) {
        Account account = accountRepository.findByAccountId(id);
        if (account==null)
            return null;
        return toResponse(account);
    }

    @Override
    public List<AccountResponse> getAll() {
        return toResponse(accountRepository.findAll());
    }

    @Override
    public AccountResponse register(RegisterForm registerForm) {
        Account current = new Account();
        current.setUsername(registerForm.getUsername());
        current.setPassword(passwordEncoder.encode(registerForm.getPassword()));
        current.setRole(registerForm.getRole());

        accountRepository.save(current);
        if (current==null)
            return null;
        return toResponse(current);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account==null)
            throw  new UsernameNotFoundException(username);
        return new CustomUserDetail(account);
    }

    AccountResponse toResponse(Account account)
    {
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setUsername(account.getUsername());
        accountResponse.setPassword(account.getPassword());
        accountResponse.setRole(account.getRole());
        accountResponse.setAccountId(account.getAccountId());
        return  accountResponse;
    }

    List<AccountResponse> toResponse(List<Account> accounts)
    {
        List<AccountResponse> accountResponses = new ArrayList<>();
        accounts.forEach(account -> accountResponses.add(toResponse(account)));
        return accountResponses;
    }
}
