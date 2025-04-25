package com.example.hospital.controller;

import com.example.hospital.model.Patient;
import com.example.hospital.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private IPatientRepository patientRepository;

    // Obtener todos los pacientes
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    // Crear o actualizar un paciente
    @PostMapping
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
        Patient savedPatient = patientRepository.save(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    // Actualizar un paciente existente
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") Long id, @RequestBody Patient patientDetails) {
        if (!patientRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Patient patient = patientRepository.findById(id).orElseThrow();
        patient.setName(patientDetails.getName());
        patient.setBirthDate(patientDetails.getBirthDate());
        patient.setGender(patientDetails.getGender());
        patient.setPhone(patientDetails.getPhone());
        patient.setAddress(patientDetails.getAddress());

        Patient updatedPatient = patientRepository.save(patient);
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }

    // Eliminar un paciente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable("id") Long id) {
        if (!patientRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        patientRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
