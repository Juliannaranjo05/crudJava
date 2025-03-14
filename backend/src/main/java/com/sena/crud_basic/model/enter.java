package com.sena.crud_basic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "enter")
public class Enter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_enter")
    private int id_enter;

    @Column(name = "id_event", nullable = false)
    private int id_event;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "available_quantity", nullable = false)
    private int available_quantity;

    // Constructor vacío (necesario para JPA)
    public Enter() {
    }

    // Constructor con parámetros
    public Enter(int id_enter, int id_event, int price, int available_quantity) {
        this.id_enter = id_enter;
        this.id_event = id_event;
        this.price = price;
        this.available_quantity = available_quantity;
    }

    // Getters y Setters
    public int getId_enter() {
        return id_enter;
    }

    public void setId_enter(int id_enter) {
        this.id_enter = id_enter;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(int available_quantity) {
        this.available_quantity = available_quantity;
    }
}