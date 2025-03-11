package com.example.hospital.controller;

import com.example.hospital.model.Doctors;
import com.example.hospital.service.DoctorsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorsController {
    private final DoctorsService service;

    public DoctorsController(DoctorsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Doctors> getAllDoctors() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Doctors> getDoctorById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public Doctors createDoctor(@RequestBody Doctors doctor) {
        return service.save(doctor);
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable int id) {
        service.deleteById(id);
    }
}
