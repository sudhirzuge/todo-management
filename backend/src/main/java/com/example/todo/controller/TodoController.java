package com.example.todo.controller;

import com.example.todo.dto.TodoDto;
import com.example.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("api/todos")      // url
@AllArgsConstructor              // constructor
public class TodoController {

    private TodoService todoService;

    // build add todo rest api
     @PostMapping
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){
        TodoDto savedTodo = todoService.addTodo(todoDto);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    // build get todo rest api
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") long todoId){
         TodoDto  todoDto =  todoService.getTodo(todoId);
         return new ResponseEntity<>(todoDto, HttpStatus.OK);
    }

    // build get all todos rest api
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos(){
         List<TodoDto> todos = todoService.getAllTodos();
    //   return new ResponseEntity<>(todos, HttpStatus.OK);
        return ResponseEntity.ok(todos);
    }

    //build update todo rest api
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> updateTodo(@RequestBody TodoDto todoDto, @PathVariable("id") Long todoId){
    TodoDto updatedTodo = todoService.updateTodo(todoDto, todoId);
    return ResponseEntity.ok(updatedTodo);
    }

    // build delete todo rest api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
         todoService.deleteTodo(todoId);
         return ResponseEntity.ok("Todo deleted succesfully");
    }

    // build complete to rest api
    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId){
       TodoDto updatedTodo =  todoService.completeTodo(todoId);
       return ResponseEntity.ok(updatedTodo);
    }

    // build incomplete todo rest api
    @PatchMapping("{id}/in-complete")
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id") Long todoId){
        TodoDto updatedTodo = todoService.inCompleteTodo(todoId);
        return ResponseEntity.ok(updatedTodo);
    }

}
