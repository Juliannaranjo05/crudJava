package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.model.Prescriptions;

public interface PrescriptionsRepository extends JpaRepository
<Prescriptions, Integer>
{

}
