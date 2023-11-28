package com.taskmanager.taskmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import com.taskmanager.taskmanager.model.task;

@Repository
public interface taskRepository extends JpaRepository<task, Integer> {
    List<task> findAll();
    task save(Task task);
}
