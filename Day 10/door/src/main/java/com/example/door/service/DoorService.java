package com.example.door.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.door.model.Door;
import com.example.door.repository.DoorRepo;

@Service
public class DoorService {

    @Autowired
    private DoorRepo doorRepo;

    public Door addDoor(Door door) {
        return doorRepo.save(door);
    }

    public List<Door> getByColor(String color) {
        return doorRepo.findByColor(color);
    }

    public List<Door> getByDoorType(String doorType) {
        return doorRepo.findByDoorType(doorType);
    }

    public List<Door> getAll() {
        return (List<Door>) doorRepo.findAll();
    }

    public Door updateDetails(int doorId, String color) {
        Optional<Door> optionalDoor = doorRepo.findById(doorId);
        if (optionalDoor.isPresent()) {
            Door door = optionalDoor.get();
            door.setColor(color);
            return doorRepo.save(door);
        }
        return null;
    }

    public String deleteById(int doorId) {
        if (doorRepo.existsById(doorId)) {
            doorRepo.deleteById(doorId);
            return "Door deleted successfully.";
        }
        return "Door not found.";
    }

    public Door getById(int doorId) {
        Optional<Door> optionalDoor = doorRepo.findById(doorId);
        return optionalDoor.orElse(null);
    }
}
