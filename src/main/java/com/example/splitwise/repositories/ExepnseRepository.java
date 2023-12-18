package com.example.splitwise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.splitwise.models.Expense;

@Repository
public interface ExepnseRepository extends JpaRepository<Expense, Long> {}
