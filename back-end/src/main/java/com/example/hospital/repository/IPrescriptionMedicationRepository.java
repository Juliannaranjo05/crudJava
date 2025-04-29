package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital.model.PrescriptionMedication;
import com.example.hospital.model.PrescriptionMedicationId;

public interface IPrescriptionMedicationRepository extends JpaRepository<PrescriptionMedication, PrescriptionMedicationId> {
}
