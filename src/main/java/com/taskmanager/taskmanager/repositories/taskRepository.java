package com.taskmanager.taskmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskmanager.taskmanager.model.User;
import com.taskmanager.taskmanager.model.Task;

@Repository
public interface taskRepository extends JpaRepository<Task, Long> {
    List<Task> findAll();
    List<Task> findByUser(User User);
    Optional<Task> findByIdAndUser_Id(Long taskId, Long userId);
}
