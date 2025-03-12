package com.sena.crud_basic.DTO;

public class PaymentsDTO {

    private int id_payments;
    private int id_shopping;
    private String payment_method;
    private String state;
    private String date_payment;

    // Constructor vacío
    public PaymentsDTO() {
    }

    // Constructor con parámetros
    public PaymentsDTO(int id_payments, int id_shopping, String payment_method, String state, String date_payment) {
        this.id_payments = id_payments;
        this.id_shopping = id_shopping;
        this.payment_method = payment_method;
        this.state = state;
        this.date_payment = date_payment;
    }

    // Getters y Setters
    public int getId_payments() {
        return id_payments;
    }

    public void setId_payments(int id_payments) {
        this.id_payments = id_payments;
    }

    public int getId_shopping() {
        return id_shopping;
    }

    public void setId_shopping(int id_shopping) {
        this.id_shopping = id_shopping;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDate_payment() {
        return date_payment;
    }

    public void setDate_payment(String date_payment) {
        this.date_payment = date_payment;
    }
}