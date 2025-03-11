package com.example.hospital.controller;

import com.example.hospital.model.Hospitalizations;
import com.example.hospital.service.HospitalizationsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hospitalizations")
public class HospitalizationsController {
    private final HospitalizationsService service;

    public HospitalizationsController(HospitalizationsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Hospitalizations> getAllHospitalizations() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Hospitalizations> getHospitalizationById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public Hospitalizations createHospitalization(@RequestBody Hospitalizations hospitalization) {
        return service.save(hospitalization);
    }

    @DeleteMapping("/{id}")
    public void deleteHospitalization(@PathVariable int id) {
        service.deleteById(id);
    }
}
