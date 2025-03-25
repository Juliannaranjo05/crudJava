package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital.model.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}
