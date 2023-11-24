package com.taskmanager.taskmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taskmanager.taskmanager.model.task;

@Repository
public interface taskRepository extends CrudRepository<task, Integer> {
    
}
