package com.example.hospital.dto;

import java.time.LocalDate;

public class HospitalizationDTO {
    private Long hospitalizationId;
    private Long patientId;
    private Long roomId;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;

    public HospitalizationDTO() {
    }

    public HospitalizationDTO(Long hospitalizationId, Long patientId, Long roomId, LocalDate admissionDate, LocalDate dischargeDate) {
        this.hospitalizationId = hospitalizationId;
        this.patientId = patientId;
        this.roomId = roomId;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
    }

    public Long getHospitalizationId() {
        return hospitalizationId;
    }

    public void setHospitalizationId(Long hospitalizationId) {
        this.hospitalizationId = hospitalizationId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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

    // Getters y Setters
}
