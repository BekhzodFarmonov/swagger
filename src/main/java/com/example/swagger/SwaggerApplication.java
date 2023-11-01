package com.example.swagger;

import com.example.swagger.entity.Comment;
import com.example.swagger.entity.Post;
import com.example.swagger.entity.Todo;
import com.example.swagger.repository.CommentRepository;
import com.example.swagger.repository.PostRepository;
import com.example.swagger.repository.TodoRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URL;
import java.util.List;

@SpringBootApplication
public class SwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(
			ObjectMapper objectMapper,
			PostRepository postRepository,
			CommentRepository commentRepository,
			TodoRepository todoRepository
	) {
		return (args -> {
			List<Comment> comments = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/comments"), new TypeReference<>() {});
			commentRepository.saveAll(comments);
			List<Post> posts = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/posts"), new TypeReference<>() {});

			postRepository.saveAll(posts);
			List<Todo> todos = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/todos"), new TypeReference<>() {});

			todoRepository.saveAll(todos);
		});
	}
}
