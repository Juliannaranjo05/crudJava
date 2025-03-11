package com.example.hospital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "hospitalizations")
public class Hospitalizations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospitalization_id")
    private int hospitalizationId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private patients patient;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Rooms room;

    @Column(name = "admission_date", nullable = false)
    private String admissionDate;

    @Column(name = "discharge_date")
    private String dischargeDate;
}
