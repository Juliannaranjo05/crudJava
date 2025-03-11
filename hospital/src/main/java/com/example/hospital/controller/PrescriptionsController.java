package com.example.hospital.controller;

import com.example.hospital.model.Prescriptions;
import com.example.hospital.service.PrescriptionsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionsController {
    private final PrescriptionsService service;

    public PrescriptionsController(PrescriptionsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Prescriptions> getAllPrescriptions() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Prescriptions> getPrescriptionById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public Prescriptions createPrescription(@RequestBody Prescriptions prescription) {
        return service.save(prescription);
    }

    @DeleteMapping("/{id}")
    public void deletePrescription(@PathVariable int id) {
        service.deleteById(id);
    }
}
