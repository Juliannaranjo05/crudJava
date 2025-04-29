package com.example.hospital.dto;

import java.time.LocalDate;

public class PatientDTO {

    private String name;
    private LocalDate birthDate;
    private String gender;
    private String phone;
    private String address;

    // Constructor vacío
    public PatientDTO() {
    }

    // Constructor con parámetros
    public PatientDTO(String name, LocalDate birthDate, String gender, String phone, String address) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
