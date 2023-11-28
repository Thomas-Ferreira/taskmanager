package com.taskmanager.taskmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.taskmanager.model.task;
import com.taskmanager.taskmanager.model.user;
import com.taskmanager.taskmanager.services.taskService;
import com.taskmanager.taskmanager.services.userService;

@RestController
@RequestMapping("/api")
public class ApiController {
    
    @Autowired
    private taskService TaskService;

    @Autowired
    private userService UserService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<task>> getAllTasks(@PathVariable Integer userId){
        user User = UserService.getUserById(userId);
        if (User != null) {
            List<task> tasksForUser = TaskService.getAllTasks(User);
            return new ResponseEntity<>(tasksForUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public task getOneTaskById(@PathVariable Integer id){
        return TaskService.getTaskById(id);
    }

    @PostMapping("/")
    public String createTask(@RequestBody task task){
        TaskService.createTask(task);
        return "task created successfully";
    }
    
}
