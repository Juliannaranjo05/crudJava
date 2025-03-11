package com.example.hospital.dto;

import java.util.Date;

public class PrescriptionsDTO {
    private int prescriptionId;
    private int patientId;
    private int doctorId;
    private Date issueDate;

    public PrescriptionsDTO() {}

    public PrescriptionsDTO(int prescriptionId, int patientId, int doctorId, Date issueDate) {
        this.prescriptionId = prescriptionId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.issueDate = issueDate;
    }

    public int getPrescriptionId() { return prescriptionId; }
    public void setPrescriptionId(int prescriptionId) { this.prescriptionId = prescriptionId; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public Date getIssueDate() { return issueDate; }
    public void setIssueDate(Date issueDate) { this.issueDate = issueDate; }
}
