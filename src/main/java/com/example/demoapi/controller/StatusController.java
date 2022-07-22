package com.example.demoapi.controller;

import com.example.demoapi.model.response.StatusResponse;
import com.example.demoapi.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {
    @Autowired
    StatusService statusService;
    @GetMapping("")
    public List<StatusResponse> getAll(){
        return statusService.getAll();
    }
}
