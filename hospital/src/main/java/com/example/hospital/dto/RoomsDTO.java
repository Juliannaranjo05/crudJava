package com.example.hospital.dto;

public class RoomsDTO {
    private int roomId;
    private int departmentId;
    private int number;
    private String status;

    public RoomsDTO() {}

    public RoomsDTO(int roomId, int departmentId, int number, String status) {
        this.roomId = roomId;
        this.departmentId = departmentId;
        this.number = number;
        this.status = status;
    }

    public int getRoomId() { return roomId; }
    public void setRoomId(int roomId) { this.roomId = roomId; }

    public int getDepartmentId() { return departmentId; }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
