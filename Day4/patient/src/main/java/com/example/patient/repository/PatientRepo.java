package com.example.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.patient.model.Patient;

public interface PatientRepo extends JpaRepository<Patient,Integer> {
    
}
