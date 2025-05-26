package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {
    
    @Value("${spring.datasource.url:not-set}")
    private String dbUrl;
    
    // Rediriger la racine vers l'index.html
    @GetMapping("/")
    public String home() {
        return "index";
    }
    
    // Endpoint API distinct pour vérifier l'état
    @GetMapping("/api/status")
    @ResponseBody
    public Map<String, String> status() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "ok");
        response.put("message", "Spring Boot PostgreSQL Demo");
        response.put("database", dbUrl);
        return response;
    }
}
