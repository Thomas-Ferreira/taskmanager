package com.taskmanager.taskmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.taskmanager.taskmanager.model.task;

@Repository
public interface taskRepository extends CrudRepository<task, Integer> {
    List<task> findAll();
}
