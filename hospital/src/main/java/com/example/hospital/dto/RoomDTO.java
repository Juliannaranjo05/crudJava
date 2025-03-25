package com.example.hospital.dto;

public class RoomDTO {
    private Long roomId;
    private int number;
    private Long departmentId;
    private String status;

    public RoomDTO() {
    }

    public RoomDTO(Long roomId, int number, Long departmentId, String status) {
        this.roomId = roomId;
        this.number = number;
        this.departmentId = departmentId;
        this.status = status;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getters y Setters
}
