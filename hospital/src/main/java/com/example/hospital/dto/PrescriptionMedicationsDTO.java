package com.example.hospital.dto;

public class PrescriptionMedicationsDTO {
    private int prescriptionId;
    private int medicationId;
    private int quantity;

    public PrescriptionMedicationsDTO() {}

    public PrescriptionMedicationsDTO(int prescriptionId, int medicationId, int quantity) {
        this.prescriptionId = prescriptionId;
        this.medicationId = medicationId;
        this.quantity = quantity;
    }

    public int getPrescriptionId() { return prescriptionId; }
    public void setPrescriptionId(int prescriptionId) { this.prescriptionId = prescriptionId; }

    public int getMedicationId() { return medicationId; }
    public void setMedicationId(int medicationId) { this.medicationId = medicationId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
