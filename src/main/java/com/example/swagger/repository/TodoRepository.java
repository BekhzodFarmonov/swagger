package com.example.swagger.repository;

 import com.example.swagger.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TodoRepository extends JpaRepository<Todo,Integer> {
}
