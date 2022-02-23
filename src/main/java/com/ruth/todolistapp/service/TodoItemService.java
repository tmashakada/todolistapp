/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ruth.todolistapp.service;

import com.ruth.todolistapp.model.TodoItem;
import java.util.List;

/**
 *
 * @author F5437172
 */
public interface TodoItemService {
    public TodoItem saveTodoItem(TodoItem todoItem);
    public TodoItem updateTodoItem(TodoItem todoItem);
    public List<TodoItem> getAllTodoItems();
    public TodoItem getTodoItemById(Long id);
    public TodoItem getTodoItemByTitle(String title);
    public String deleteTodoItemById(Long id);
}
