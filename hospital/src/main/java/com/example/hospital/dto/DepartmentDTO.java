package com.example.hospital.dto;

public class DepartmentDTO {
    private Long departmentId;
    private String name;
    private String location;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long departmentId, String name, String location) {
        this.departmentId = departmentId;
        this.name = name;
        this.location = location;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Getters y Setters
}
