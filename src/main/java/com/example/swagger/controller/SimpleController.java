package com.example.swagger.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
public class SimpleController {
    @Value("${example_string}")
    private String exampleString;
    @GetMapping("/exaample")
    public String example(){
        return exampleString;
    }
}
