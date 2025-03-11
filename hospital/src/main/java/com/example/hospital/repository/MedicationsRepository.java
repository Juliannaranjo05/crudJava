package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.model.Medications;

public interface MedicationsRepository extends JpaRepository
<Medications, Integer>
{

}
