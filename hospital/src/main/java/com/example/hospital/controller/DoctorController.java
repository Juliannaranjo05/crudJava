package com.example.hospital.controller;

import com.example.hospital.dto.DoctorDTO;
import com.example.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Obtener todos los doctores
    @GetMapping
    public List<DoctorDTO> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // Obtener doctor por ID
    @GetMapping("/{id}")
    public Optional<DoctorDTO> getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    // Crear nuevo doctor
    @PostMapping
    public DoctorDTO createDoctor(@RequestBody DoctorDTO doctorDTO) {
        return doctorService.createDoctor(doctorDTO);
    }

    // Actualizar doctor
    @PutMapping("/{id}")
    public DoctorDTO updateDoctor(@PathVariable Long id, @RequestBody DoctorDTO doctorDTO) {
        return doctorService.updateDoctor(id, doctorDTO);
    }

    // Eliminar doctor
    @DeleteMapping("/{id}")
    public boolean deleteDoctor(@PathVariable Long id) {
        return doctorService.deleteDoctor(id);
    }
}
