package com.example.hospital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PrescriptionMedications")
public class PrescriptionMedications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    @JoinColumn(name = "prescription_id", nullable = false)
    public Prescriptions prescription;

    @ManyToOne
    @JoinColumn(name = "medication_id", nullable = false)
    public Medications medication;

    @Column(nullable = false)
    public int quantity;
}