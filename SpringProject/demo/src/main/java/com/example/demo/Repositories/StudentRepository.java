package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
    // You can add custom queries here if needed
}
