package com.example.hospital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity(name = "medications")
public class Medications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medication_id")
    private int medicationId;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Lob
    @Column(name = "description")
    private String description;
}
