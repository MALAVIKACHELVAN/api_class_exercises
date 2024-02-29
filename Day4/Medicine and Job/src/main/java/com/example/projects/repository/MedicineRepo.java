package com.example.projects.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projects.model.MedicineDetails;
public interface MedicineRepo extends JpaRepository<MedicineDetails,Integer>
 {
    
}
