package com.taskmanager.taskmanager.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.taskmanager.model.Task;
import com.taskmanager.taskmanager.model.TaskRequest;
import com.taskmanager.taskmanager.model.TaskResponse;
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

    @GetMapping("/{userId}/userInfo")
    public ResponseEntity<User> getUserInfo(@PathVariable Long userId){
        User user = UserService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<TaskResponse>> getTasksForUsers(@PathVariable Long userId){
        User user = UserService.getUserById(userId);
        if (user != null) {
            List<Task> tasksForUser = TaskService.getAllTasks(user);
            List<TaskResponse> response = tasksForUser.stream().map(TaskResponse::fromTask).collect(Collectors.toList());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{userId}/{taskId}")
    public ResponseEntity<TaskResponse> getOneTaskById(@PathVariable Long userId, @PathVariable Long taskId){
        Optional<Task> taskOptional = TaskService.getTaskByUserAndId(taskId, userId);
        if (taskOptional.isPresent()) {
            TaskResponse taskResponse = TaskResponse.fromTask(taskOptional.get());
            return new ResponseEntity<>(taskResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Task> createTask(@PathVariable Long userId, @RequestBody TaskRequest taskRequest){
        User user = UserService.getUserById(userId);
        Task newTask = new Task(taskRequest.getTitre(), taskRequest.getContenu(), user);
        Task response = TaskService.createTaskForUser(newTask);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long userId, @PathVariable Long taskId){
        TaskService.deleteTaskByIdAndUserId(taskId, userId);
        return new ResponseEntity<>("task deleted", HttpStatus.OK);
    }
    
}
