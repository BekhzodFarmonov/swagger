package com.example.swagger.controller;

import com.example.swagger.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SimpleController {
 private  final YamlProporties yamlProporties;
    @Value("${example.string}")
    private String exampleString;
    @GetMapping("/example")
    public String example(){
        return exampleString;
    }
@GetMapping("/exampleLanguages")
    public List<String> exampleLan(){
        return yamlProporties.getLanguages();
    }
    @GetMapping("/person")
    public Person exPerson(){
        return yamlProporties.getPerson();
    }

}
