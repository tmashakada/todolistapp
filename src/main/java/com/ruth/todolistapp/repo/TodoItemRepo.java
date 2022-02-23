/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ruth.todolistapp.repo;

import com.ruth.todolistapp.model.TodoItem;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author F5437172
 */
@Repository
public interface TodoItemRepo extends JpaRepository<TodoItem, Long>{
     Optional<TodoItem> findTodoItemByTitleIgnoreCase(String title);
}
