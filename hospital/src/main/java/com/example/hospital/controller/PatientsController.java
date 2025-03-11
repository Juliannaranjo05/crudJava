package com.example.hospital.controller;

import com.example.hospital.model.patients;
import com.example.hospital.service.PatientsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientsController {
    private final PatientsService service;

    public PatientsController(PatientsService service) {
        this.service = service;
    }

    @GetMapping
    public List<patients> getAllPatients() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<patients> getPatientById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public patients createPatient(@RequestBody patients patient) {
        return service.save(patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable int id) {
        service.deleteById(id);
    }
}
