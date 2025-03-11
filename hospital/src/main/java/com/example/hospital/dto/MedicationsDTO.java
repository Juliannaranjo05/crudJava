package com.example.hospital.dto;

public class MedicationsDTO {
    private int medicationId;
    private String name;
    private String description;

    public MedicationsDTO() {}

    public MedicationsDTO(int medicationId, String name, String description) {
        this.medicationId = medicationId;
        this.name = name;
        this.description = description;
    }

    public int getMedicationId() { return medicationId; }
    public void setMedicationId(int medicationId) { this.medicationId = medicationId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
