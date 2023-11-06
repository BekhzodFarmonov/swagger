package com.example.swagger.controller;
import com.example.swagger.Person;
import com.example.swagger.PersonProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SimpleController {
    private final PersonProperties personProperties;
    @Value("${example_string}")
    private String exampleString;
    @Value("${example.lenguages}")
    private List<String> language;
    @GetMapping("/example")
    public String example(){
        return exampleString;
    }
    @GetMapping("/language")
    public List<String> language(){
        return language;
    }
    @GetMapping("/person")
    public Person person(){
        return personProperties.getPerson();
    }
}
