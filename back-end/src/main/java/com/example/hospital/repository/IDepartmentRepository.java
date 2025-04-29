package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital.model.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
}
