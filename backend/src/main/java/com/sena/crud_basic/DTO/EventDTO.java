package com.sena.crud_basic.DTO;

public class EventDTO {
    private int id_event;
    private String title;
    private String description;
    private String date_event;
    private String ubication;
    private int id_organizer;
    private int id_category;

    // Constructor vacío
    public EventDTO() {}

    // Constructor con parámetros
    public EventDTO(int id_event, String title, String description, String date_event, String ubication, int id_organizer, int id_category) {
        this.id_event = id_event;
        this.title = title;
        this.description = description;
        this.date_event = date_event;
        this.ubication = ubication;
        this.id_organizer = id_organizer;
        this.id_category = id_category;
    }

    // Getters y Setters
    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_event() {
        return date_event;
    }

    public void setDate_event(String date_event) {
        this.date_event = date_event;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public int getId_organizer() {
        return id_organizer;
    }

    public void setId_organizer(int id_organizer) {
        this.id_organizer = id_organizer;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
}