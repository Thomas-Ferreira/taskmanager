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

import com.taskmanager.taskmanager.model.Task;
import com.taskmanager.taskmanager.model.User;
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
    public ResponseEntity<List<Task>> getTasksForUsers(@PathVariable Integer userId){
        User user = UserService.getUserById(userId);
        if (user != null) {
            List<Task> tasksForUser = TaskService.getAllTasks(user);
            return new ResponseEntity<>(tasksForUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/test/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Integer userId){
        User user = UserService.getUserById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*@GetMapping("/{userId}/{id}")
    public Task getOneTaskById(@PathVariable Integer userId, @PathVariable Integer id){
        return TaskService.getTaskById(id);
    }*/

    @PostMapping("/")
    public String createTask(@RequestBody Task task){
        TaskService.createTask(task);
        return "task created successfully";
    }
    
}
