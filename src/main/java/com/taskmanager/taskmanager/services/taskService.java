package com.taskmanager.taskmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanager.repositories.taskRepository;
import com.taskmanager.taskmanager.model.task;

@Service
public class taskService {

    private final taskRepository taskRepository;

    @Autowired
    public taskService(taskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public Iterable<task> getAllTasks() {
        return taskRepository.findAll();
    }

    public task getTaskById(Integer taskId){
        return taskRepository.findById(taskId).orElse(null);
    }
    
}
