package com.example.hospital.controller;

import com.example.hospital.model.PrescriptionMedications;
import com.example.hospital.service.PrescriptionMedicationsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prescription-medications")
public class PrescriptionMedicationsController {
    private final PrescriptionMedicationsService service;

    public PrescriptionMedicationsController(PrescriptionMedicationsService service) {
        this.service = service;
    }

    @GetMapping
    public List<PrescriptionMedications> getAllPrescriptionMedications() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PrescriptionMedications> getPrescriptionMedicationById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public PrescriptionMedications createPrescriptionMedication(@RequestBody PrescriptionMedications prescriptionMedication) {
        return service.save(prescriptionMedication);
    }

    @DeleteMapping("/{id}")
    public void deletePrescriptionMedication(@PathVariable int id) {
        service.deleteById(id);
    }
}
