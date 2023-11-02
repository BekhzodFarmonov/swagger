package com.example.swagger.config.criteria;


import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springdoc.core.annotations.ParameterObject;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@ParameterObject
public class TodoCriteria {
    private String title;
    @Parameter(required = true)
    private Type type;
    private  boolean completed;
    private LocalDate createdDate;
    private Integer userId;
    private  enum Type{
        EDUCATION,IT,SPORT
    }
}
