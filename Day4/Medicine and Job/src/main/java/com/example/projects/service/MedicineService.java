package com.example.projects.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.projects.model.MedicineDetails;
import com.example.projects.repository.MedicineRepo;

@Service
public class MedicineService {
    private MedicineRepo medicineRepo;
    public MedicineService(MedicineRepo medicineRepo)
    {
        this.medicineRepo=medicineRepo;
    }
    public ResponseEntity<MedicineDetails> getMedicine(MedicineDetails medicineDetails)
    {
        if(medicineDetails==null)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        medicineRepo.save(medicineDetails);
        return new ResponseEntity<>(medicineDetails,HttpStatus.CREATED);
    }
    public List<MedicineDetails>getMedicineDetails()
    {
        return medicineRepo.findAll();
    }
    public MedicineDetails saveMedicines(MedicineDetails medicineDetails)
    {
        return medicineRepo.save(medicineDetails);
    }
    public MedicineDetails getById(int id)
    {
        return medicineRepo.findById(id).orElse(null);
    }
}
