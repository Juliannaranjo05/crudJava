package com.example.hospital.dto;

public class DepartmentsDTO {
    private int departmentId;
    private String name;
    private String location;

    public DepartmentsDTO() {}

    public DepartmentsDTO(int departmentId, String name, String location) {
        this.departmentId = departmentId;
        this.name = name;
        this.location = location;
    }

    public int getDepartmentId() { return departmentId; }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
