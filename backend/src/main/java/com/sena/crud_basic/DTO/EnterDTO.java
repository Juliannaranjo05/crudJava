package com.sena.crud_basic.DTO;

public class EnterDTO {
    private int id_enter;
    private int id_event;
    private int price;
    private int available_quantity;

    public EnterDTO() {
    }

    public EnterDTO(int id_enter, int id_event, int price, int available_quantity) {
        this.id_enter = id_enter;
        this.id_event = id_event;
        this.price = price;
        this.available_quantity = available_quantity;
    }

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