package com.example.todo.repository;

import com.example.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    // as this Todorepo extending jparepo it getting all methods to do crud operation on todo entity

}
