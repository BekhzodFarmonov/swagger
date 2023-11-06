package com.example.swagger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String  id;
    private String firstName;
    private String lastName;
    private String fullName;
    private Integer age;

}
