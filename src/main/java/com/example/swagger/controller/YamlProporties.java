package com.example.swagger.controller;

import com.example.swagger.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "example")
public class YamlProporties {
private List<String> languages;
private Person person;
}
