package com.example.demoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApiApplication {

    @GetMapping("/")
    List<String> getInit(){
        return new ArrayList<>(List.of("a","b","c"));
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApiApplication.class, args);
    }

}
