/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ruth.todolistapp.service;

import com.ruth.todolistapp.exception.ResourceNotFoundException;
import com.ruth.todolistapp.model.TodoItem;
import com.ruth.todolistapp.repo.TodoItemRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author F5437172
 */
@Service
public class TodoItemServiceImpl implements  TodoItemService{
    
    @Autowired
    private TodoItemRepo   todoItemRepo;
    
    @Override
    public TodoItem saveTodoItem(TodoItem todoItem) {
        return todoItemRepo.save(todoItem);
    }

    @Override
    public TodoItem updateTodoItem(TodoItem todoItem) {
        TodoItem existingTodoItem=this.todoItemRepo.findById(todoItem.getId())
     		   .orElseThrow(() -> new ResourceNotFoundException("TodoItem Not Found with "+todoItem.getId()));
        existingTodoItem.setDone(todoItem.isDone());
        existingTodoItem.setTitle(todoItem.getTitle());
        
         return todoItemRepo.save(existingTodoItem);
    }

    @Override
    public List<TodoItem> getAllTodoItems() {
         return todoItemRepo.findAll();
    }

    @Override
    public TodoItem getTodoItemById(Long id) {
        
         return todoItemRepo.findById(id)
    		   .orElseThrow(() -> new ResourceNotFoundException("TodoItem Not Found with "+id));
    }

    @Override
    public String deleteTodoItemById(Long id) {
          todoItemRepo.deleteById(id);
        return "Success Deleted";
    }

    @Override
    public TodoItem getTodoItemByTitle(String title) {
        return  todoItemRepo.findTodoItemByTitleIgnoreCase(title)
    		   .orElseThrow(() -> new ResourceNotFoundException("TodoItem Not Found with "+title));
    }
    
}
