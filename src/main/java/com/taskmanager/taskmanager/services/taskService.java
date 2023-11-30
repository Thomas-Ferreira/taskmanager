package com.taskmanager.taskmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanager.repositories.taskRepository;
import com.taskmanager.taskmanager.model.Task;
import com.taskmanager.taskmanager.model.User;

@Service
public class taskService {

    private final taskRepository TaskRepository;

    @Autowired
    public taskService(taskRepository TaskRepository){
        this.TaskRepository = TaskRepository;
    }

    public List<Task> getAllTasks(User User) {
        return TaskRepository.findByUser(User);
    }

    public Optional<Task> getTaskByUserAndId(Long taskId, Long userId){
        return TaskRepository.findByIdAndUser_Id(taskId, userId);
    }

    public Task createTaskForUser(Task task){
        return TaskRepository.save(task);
    }
    
}
