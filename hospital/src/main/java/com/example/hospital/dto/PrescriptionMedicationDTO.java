package com.example.hospital.dto;

public class PrescriptionMedicationDTO {
    private Long prescriptionId;
    private Long medicationId;
    private int quantity;

    public PrescriptionMedicationDTO() {
    }

    public PrescriptionMedicationDTO(Long prescriptionId, Long medicationId, int quantity) {
        this.prescriptionId = prescriptionId;
        this.medicationId = medicationId;
        this.quantity = quantity;
    }

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(Long medicationId) {
        this.medicationId = medicationId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getters y Setters
}
