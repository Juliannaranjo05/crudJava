package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital.model.Hospitalization;

public interface IHospitalizationRepository extends JpaRepository<Hospitalization, Integer> {
}
