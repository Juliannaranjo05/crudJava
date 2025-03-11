package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.model.Appointments;

public interface AppointmentsRepository extends JpaRepository
<Appointments, Integer>
{

}
