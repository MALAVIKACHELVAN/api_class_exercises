package com.example.childrenpagination.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Children {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int babyId;
    
    private String babyFirstName,babyLastName,fathername,mothername,address;
    Children()
    {

    }
    public Children(int babyId, String babyFirstName, String babyLastName, String fathername, String mothername,
            String address) {
        this.babyId = babyId;
        this.babyFirstName = babyFirstName;
        this.babyLastName = babyLastName;
        this.fathername = fathername;
        this.mothername = mothername;
        this.address = address;
    }
    public int getBabyId() {
        return babyId;
    }
    public void setBabyId(int babyId) {
        this.babyId = babyId;
    }
    public String getBabyFirstName() {
        return babyFirstName;
    }
    public void setBabyFirstName(String babyFirstName) {
        this.babyFirstName = babyFirstName;
    }
    public String getBabyLastName() {
        return babyLastName;
    }
    public void setBabyLastName(String babyLastName) {
        this.babyLastName = babyLastName;
    }
    public String getFathername() {
        return fathername;
    }
    public void setFathername(String fathername) {
        this.fathername = fathername;
    }
    public String getMothername() {
        return mothername;
    }
    public void setMothername(String mothername) {
        this.mothername = mothername;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
}
