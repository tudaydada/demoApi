package com.example.demoapi.services.impl;

import com.example.demoapi.model.Account;
import com.example.demoapi.repository.AccountRepository;
import com.example.demoapi.services.AccountService;
import com.example.demoapi.until.CustomUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {
    @Autowired
    AccountRepository  accountRepository;
    @Override
    public UserDetails getById(Long id) {
        Account account = accountRepository.findByAccountId(id);
        if (account==null)
            throw  new UsernameNotFoundException(id.toString());
        return new CustomUserDetail(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account==null)
            throw  new UsernameNotFoundException(username);
        return new CustomUserDetail(account);
    }
}
