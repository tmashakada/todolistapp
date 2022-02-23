/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ruth.todolistapp.controller;

import com.ruth.todolistapp.service.TodoItemServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruth.todolistapp.model.TodoItem;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
/**
 *
 * @author F5437172
 */
@RestController
@RequestMapping("/todo")
//@RequestMapping(value = "/todo")
public class TodoItemController {
    
   @Autowired 
   private  TodoItemServiceImpl todoItemServiceImpl;
   
   
    @GetMapping
    public List<TodoItem> findAll(){
        return todoItemServiceImpl.getAllTodoItems();
    }
   // Save operation
    @PostMapping
    public TodoItem saveTodoItem(@Valid @RequestBody TodoItem todoItem)
    {
        return todoItemServiceImpl.saveTodoItem(todoItem);
    }
    @PutMapping
    public TodoItem updateTodoItem(@Valid @RequestBody TodoItem todoItem)
    {
        return todoItemServiceImpl.updateTodoItem(todoItem);
    }
    
    @GetMapping("/{title}")
    public TodoItem getTodoItem(@PathVariable("title")
                                       String todoItemTitle)
    {
        return todoItemServiceImpl.getTodoItemByTitle(todoItemTitle);
    }
    
    
     // Delete operation
    @DeleteMapping("/{id}")
    public String deleteTodoItemById(@PathVariable("id")
                                       Long todoItemId)
    {
        todoItemServiceImpl.deleteTodoItemById(todoItemId);
  
        return "Deleted Successfully";
    }
}
