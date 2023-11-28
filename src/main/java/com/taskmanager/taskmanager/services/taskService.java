package com.taskmanager.taskmanager.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanager.repositories.taskRepository;
import com.taskmanager.taskmanager.model.task;
import com.taskmanager.taskmanager.model.user;

@Service
public class taskService {

    private final taskRepository TaskRepository;

    @Autowired
    public taskService(taskRepository TaskRepository){
        this.TaskRepository = TaskRepository;
    }

    public List<task> getAllTasks(user User) {
        return TaskRepository.findByUser(User);
    }

    public task getTaskById(Integer taskId){
        return TaskRepository.findById(taskId).orElse(null);
    }

    public task createTask(task task){
        return TaskRepository.save(task);
    }
    
}
