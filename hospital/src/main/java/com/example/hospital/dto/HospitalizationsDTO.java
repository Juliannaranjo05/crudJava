package com.example.hospital.dto;

import java.util.Date;

public class HospitalizationsDTO {
    private int hospitalizationId;
    private int patientId;
    private int roomId;
    private Date admissionDate;
    private Date dischargeDate;

    public HospitalizationsDTO() {}

    public HospitalizationsDTO(int hospitalizationId, int patientId, int roomId, Date admissionDate, Date dischargeDate) {
        this.hospitalizationId = hospitalizationId;
        this.patientId = patientId;
        this.roomId = roomId;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
    }

    public int getHospitalizationId() { return hospitalizationId; }
    public void setHospitalizationId(int hospitalizationId) { this.hospitalizationId = hospitalizationId; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public int getRoomId() { return roomId; }
    public void setRoomId(int roomId) { this.roomId = roomId; }

    public Date getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(Date admissionDate) { this.admissionDate = admissionDate; }

    public Date getDischargeDate() { return dischargeDate; }
    public void setDischargeDate(Date dischargeDate) { this.dischargeDate = dischargeDate; }
}
