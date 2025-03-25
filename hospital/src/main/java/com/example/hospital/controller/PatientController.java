package com.example.hospital.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.hospital.dto.PatientDTO;
import com.example.hospital.service.PatientService;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // ✅ Crear un nuevo paciente
    @PostMapping("/")
    public ResponseEntity<Object> registerPatient(@RequestBody PatientDTO patientDTO) {
        String response = patientService.save(patientDTO);
        if (response.equals("Paciente guardado exitosamente")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    // ✅ Obtener todos los pacientes
    @GetMapping("/")
    public ResponseEntity<Object> getAllPatients() {
        return new ResponseEntity<>(patientService.findAll(), HttpStatus.OK);
    }

    // ✅ Obtener un paciente por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getPatientById(@PathVariable Long id) {
        Optional<PatientDTO> patient = patientService.findById(id).map(patientService::convertToDTO);
        return patient.isPresent()
                ? new ResponseEntity<>(patient.get(), HttpStatus.OK)
                : new ResponseEntity<>("Paciente no encontrado", HttpStatus.NOT_FOUND);
    }

    // ✅ Eliminar un paciente por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable Long id) {
        String response = patientService.deletePatient(id);
        if (response.equals("Paciente eliminado correctamente")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
