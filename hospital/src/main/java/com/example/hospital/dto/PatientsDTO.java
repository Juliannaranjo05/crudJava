package com.example.hospital.dto;

import java.util.Date;

public class PatientsDTO {
    private int patientId;
    private String name;
    private Date birthDate;
    private String gender;
    private String phone;
    private String address;

    public PatientsDTO() {}

    public PatientsDTO(int patientId, String name, Date birthDate, String gender, String phone, String address) {
        this.patientId = patientId;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
    }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
