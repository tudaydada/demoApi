package com.example.demoapi.services;

import com.example.demoapi.model.response.StatusResponse;

import java.util.List;

public interface StatusService {
    List<StatusResponse> getAll();
    StatusResponse getById(Long id);
    boolean IsExist(Long id);
}
