package com.example.hospital.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PrescriptionMedicationId implements Serializable {

    private Long prescriptionId;
    private Long medicationId;

    public PrescriptionMedicationId() {
    }

    public PrescriptionMedicationId(Long prescriptionId, Long medicationId) {
        this.prescriptionId = prescriptionId;
        this.medicationId = medicationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrescriptionMedicationId that = (PrescriptionMedicationId) o;
        return Objects.equals(prescriptionId, that.prescriptionId) &&
               Objects.equals(medicationId, that.medicationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prescriptionId, medicationId);
    }
}
