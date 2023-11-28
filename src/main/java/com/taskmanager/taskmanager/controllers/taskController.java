package com.taskmanager.taskmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.taskmanager.model.task;
import com.taskmanager.taskmanager.services.taskService;

@RestController
@RequestMapping("/api")
public class taskController {
    
    private final taskService TaskService;

    @Autowired
    public taskController(taskService TaskService){
        this.TaskService = TaskService;
    }

    @GetMapping("/")
    public List<task> getAllTasks(){
        List<task> tasks = TaskService.getAllTasks();
        return tasks;
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
