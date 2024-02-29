package com.example.projects.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.projects.model.MedicineDetails;
import com.example.projects.service.MedicineService;


@RestController
public class MedicineController {
  private MedicineService medicineService;
  public MedicineController(MedicineService s)
  {
    medicineService=s;
  }
  @PostMapping("/medicine")
  public ResponseEntity<MedicineDetails>postMethodName(@RequestBody MedicineDetails medicineDetails)
  {
    return medicineService.getMedicine(medicineDetails);
  }
  
  @GetMapping("/medicine")
  public ResponseEntity<List<MedicineDetails>> getMethodName() {
      List<MedicineDetails>list=medicineService.getMedicineDetails();
      if(list.isEmpty())
      {
        return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(list,HttpStatus.OK);
  }
  @GetMapping("/medicines/{id}")
  public ResponseEntity<MedicineDetails> getMedicine(@PathVariable("id") int id) {
    MedicineDetails md=medicineService.getById(id);
    if(md==null)
    {
      return new ResponseEntity<>(md,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    else
    {
      return new ResponseEntity<>(md,HttpStatus.OK);
    }
  }
}
  
  
    
