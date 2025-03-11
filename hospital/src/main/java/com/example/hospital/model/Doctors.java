package com.example.hospital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "doctors")
public class Doctors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private int doctorId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "specialty", nullable = false, length = 100)
    private String specialty;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;
}