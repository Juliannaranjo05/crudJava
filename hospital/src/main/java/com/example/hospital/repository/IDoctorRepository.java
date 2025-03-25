package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital.model.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
}
