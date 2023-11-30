package com.taskmanager.taskmanager.repositories;

import org.springframework.stereotype.Repository;

import com.taskmanager.taskmanager.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface userRepository extends JpaRepository<User, Long> {
    
}
