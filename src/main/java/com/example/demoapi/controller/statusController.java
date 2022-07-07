package com.example.demoapi.controller;

import com.example.demoapi.model.status;
import com.example.demoapi.repository.statusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/status")
public class statusController {
    @Autowired
    statusRepository statusRepository;
    @GetMapping("/")
    public List<status> getAllStatus(){
        return statusRepository.findAll();
    }
}
