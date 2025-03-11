package com.example.hospital.controller;

import com.example.hospital.model.Medications;
import com.example.hospital.service.MedicationsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medications")
public class MedicationsController {
    private final MedicationsService service;

    public MedicationsController(MedicationsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Medications> getAllMedications() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Medications> getMedicationById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public Medications createMedication(@RequestBody Medications medication) {
        return service.save(medication);
    }

    @DeleteMapping("/{id}")
    public void deleteMedication(@PathVariable int id) {
        service.deleteById(id);
    }
}
