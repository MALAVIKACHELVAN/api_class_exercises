package com.example.door.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.door.model.Door;
import com.example.door.service.DoorService;

@RestController
@RequestMapping("/api/door")
public class DoorController {

    @Autowired
    private DoorService doorService;

    @PostMapping
    public ResponseEntity<Door> addDoor(@RequestBody Door door) {
        Door createdDoor = doorService.addDoor(door);
        if (createdDoor != null) {
            return new ResponseEntity<>(createdDoor, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bycolor/{color}")
    public ResponseEntity<List<Door>> getByColor(@PathVariable String color) {
        List<Door> doors = doorService.getByColor(color);
        if (!doors.isEmpty()) {
            return new ResponseEntity<>(doors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/bydoortype")
    public ResponseEntity<List<Door>> getByDoorType(@RequestParam String doorType) {
        List<Door> doors = doorService.getByDoorType(doorType);
        if (!doors.isEmpty()) {
            return new ResponseEntity<>(doors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Door>> getAll() {
        List<Door> doors = doorService.getAll();
        if (!doors.isEmpty()) {
            return new ResponseEntity<>(doors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{doorId}")
    public ResponseEntity<Door> updateDetails(@PathVariable int doorId, @RequestParam String color) {
        Door updatedDoor = doorService.updateDetails(doorId, color);
        if (updatedDoor != null) {
            return new ResponseEntity<>(updatedDoor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{doorId}")
    public ResponseEntity<String> deleteById(@PathVariable int doorId) {
        String result = doorService.deleteById(doorId);
        if (result.equals("Door deleted successfully.")) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{doorId}")
    public ResponseEntity<Door> getById(@PathVariable int doorId) {
        Door door = doorService.getById(doorId);
        if (door != null) {
            return new ResponseEntity<>(door, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
