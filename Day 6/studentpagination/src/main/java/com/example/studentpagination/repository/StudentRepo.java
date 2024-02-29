package com.example.studentpagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentpagination.model.Student;

public interface StudentRepo extends JpaRepository<Student,Integer> {
    
}
