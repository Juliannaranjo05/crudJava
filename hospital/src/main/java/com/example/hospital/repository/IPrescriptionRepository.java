package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital.model.Prescription;

public interface IPrescriptionRepository extends JpaRepository<Prescription, Integer> {
}
