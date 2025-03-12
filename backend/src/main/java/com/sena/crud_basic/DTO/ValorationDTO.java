package com.sena.crud_basic.DTO;

public class ValorationDTO {
    private int id_valoration;
    private int id_user;
    private int id_event;
    private int puntuation;
    private String date_valoration;

    // Constructor vacío
    public ValorationDTO() {}

    // Constructor con parámetros
    public ValorationDTO(int id_valoration, int id_user, int id_event, int puntuation, String date_valoration) {
        this.id_valoration = id_valoration;
        this.id_user = id_user;
        this.id_event = id_event;
        this.puntuation = puntuation;
        this.date_valoration = date_valoration;
    }

    // Getters y Setters
    public int getId_valoration() { return id_valoration; }
    public void setId_valoration(int id_valoration) { this.id_valoration = id_valoration; }

    public int getId_user() { return id_user; }
    public void setId_user(int id_user) { this.id_user = id_user; }

    public int getId_event() { return id_event; }
    public void setId_event(int id_event) { this.id_event = id_event; }

    public int getPuntuation() { return puntuation; }
    public void setPuntuation(int puntuation) { this.puntuation = puntuation; }

    public String getDate_valoration() { return date_valoration; }
    public void setDate_valoration(String date_valoration) { this.date_valoration = date_valoration; }
}
