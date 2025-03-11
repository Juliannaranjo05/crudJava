package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.model.Departments;

public interface DepartmentsRepository extends JpaRepository
<Departments, Integer>
{

}
