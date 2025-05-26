package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    
    @Value("${spring.datasource.url:not-set}")
    private String dbUrl;
    
    @GetMapping("/")
    public Map<String, String> home() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "ok");
        response.put("message", "Spring Boot PostgreSQL Demo");
        response.put("database", dbUrl);
        return response;
    }
}
