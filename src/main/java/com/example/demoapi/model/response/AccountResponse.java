package com.example.demoapi.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {

    private Long accountId;
    private String username;
    private String password;
    private String role;
}
