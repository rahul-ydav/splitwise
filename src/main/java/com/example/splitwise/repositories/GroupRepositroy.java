package com.example.splitwise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.splitwise.models.Group;

public interface GroupRepositroy extends JpaRepository<Group, Long> {
    
}
