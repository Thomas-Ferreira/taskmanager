package com.taskmanager.taskmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
