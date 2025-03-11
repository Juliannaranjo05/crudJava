package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.model.patients;

public interface PatientsRepository extends JpaRepository
<patients, Integer> 
{

}
