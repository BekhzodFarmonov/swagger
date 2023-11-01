package com.example.springboot.controller;

import com.example.springboot.entity.Todo;
import com.example.springboot.exseption.EntityNotFoundException;
import com.example.springboot.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {
  private  final TodoRepository todoRepository;
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getComment(@PathVariable Integer id ){

        Todo todo = todoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment Not Found" + id));
        return ResponseEntity.ok(todo);
    }
    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllComment(){
        List<Todo> all = todoRepository.findAll();
        return ResponseEntity.ok(all);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer id){
        Todo todo= todoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment Not Found" + id));
        todoRepository.delete(todo);
        return ResponseEntity.notFound().build();
    }
    @PostMapping("/save")
    public ResponseEntity<Todo>  saveComment(@RequestBody Todo todo){
        return ResponseEntity.status(HttpStatus.CREATED).body(todoRepository.save(todo));
    }
}
