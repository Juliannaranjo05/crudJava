package com.example.hospital.repository;

import com.example.hospital.model.PrescriptionMedications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionMedicationsRepository extends JpaRepository
<PrescriptionMedications, Integer> 
{

}
