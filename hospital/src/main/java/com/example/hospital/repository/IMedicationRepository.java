package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital.model.Medication;

public interface IMedicationRepository extends JpaRepository<Medication, Integer> {
}
