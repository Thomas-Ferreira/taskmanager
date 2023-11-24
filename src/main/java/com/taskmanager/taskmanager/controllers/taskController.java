package com.taskmanager.taskmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.taskmanager.taskmanager.model.task;
import com.taskmanager.taskmanager.services.taskService;

@Controller
public class taskController {
    
    private final taskService TaskService;

    @Autowired
    public taskController(taskService TaskService){
        this.TaskService = TaskService;
    }
}
