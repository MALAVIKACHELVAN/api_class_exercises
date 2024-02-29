package com.example.door.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.door.model.Door;

public interface DoorRepo extends CrudRepository<Door, Integer> {

    @Query("SELECT d FROM Door d WHERE d.color = :color")
    List<Door> findByColor(@Param("color") String color);

    @Query("SELECT d FROM Door d WHERE d.doorType = :doorType")
    List<Door> findByDoorType(@Param("doorType") String doorType);

    // Corrected query for findById
    Optional<Door> findById(@Param("doorId") int doorId);
}
