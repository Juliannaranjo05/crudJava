package com.example.hospital.controller;

import com.example.hospital.model.Rooms;
import com.example.hospital.service.RoomsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomsController {
    private final RoomsService service;

    public RoomsController(RoomsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Rooms> getAllRooms() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Rooms> getRoomById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public Rooms createRoom(@RequestBody Rooms room) {
        return service.save(room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable int id) {
        service.deleteById(id);
    }
}
