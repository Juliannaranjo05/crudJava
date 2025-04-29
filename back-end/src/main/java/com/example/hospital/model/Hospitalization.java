package com.example.hospital.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hospitalizations")
public class Hospitalization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hospitalizationId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @Column(nullable = false)
    private LocalDate admissionDate;

    private LocalDate dischargeDate;

    public Long getHospitalizationId() {
        return hospitalizationId;
    }

    public void setHospitalizationId(Long hospitalizationId) {
        this.hospitalizationId = hospitalizationId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    
}
