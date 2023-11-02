package com.example.swagger.controller;

import com.example.swagger.config.criteria.TodoCriteria;
import com.example.swagger.entity.Todo;
import com.example.swagger.exseption.EntityNotFoundException;
import com.example.swagger.repository.TodoRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {
  private  final TodoRepository todoRepository;
    @Tag(name = "Todo Controller",description = "This controller for todo entity")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Found Todo this for id",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation=Todo.class))
                    }),
            @ApiResponse(
                    responseCode = "404",
                    description = "Found Todo this for id",
                    content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation=EntityNotFoundException.class))
                    })

    })
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getComment(@PathVariable Integer id ){

        Todo todo = todoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment Not Found" + id));
        return ResponseEntity.ok(todo);
    }
    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllComment(TodoCriteria todoCriteria){
        System.out.println("todoCriteria = " + todoCriteria);
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
