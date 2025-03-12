package com.sena.crud_basic.DTO;

public class ShoppingDTO {
    private int id_shopping;
    private int id_user;
    private int id_enter;
    private int amount;
    private String date_shopping;

    public ShoppingDTO() {}

    public ShoppingDTO(int id_shopping, int id_user, int id_enter, int amount, String date_shopping) {
        this.id_shopping = id_shopping;
        this.id_user = id_user;
        this.id_enter = id_enter;
        this.amount = amount;
        this.date_shopping = date_shopping;
    }

    public int getId_shopping() { return id_shopping; }
    public void setId_shopping(int id_shopping) { this.id_shopping = id_shopping; }

    public int getId_user() { return id_user; }
    public void setId_user(int id_user) { this.id_user = id_user; }

    public int getId_enter() { return id_enter; }
    public void setId_enter(int id_enter) { this.id_enter = id_enter; }

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    public String getDate_shopping() { return date_shopping; }
    public void setDate_shopping(String date_shopping) { this.date_shopping = date_shopping; }
}