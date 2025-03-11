package com.example.hospital.dto;

import java.util.Date;

public class InvoicesDTO {
    private int invoiceId;
    private int patientId;
    private Date date;
    private double total;

    public InvoicesDTO() {}

    public InvoicesDTO(int invoiceId, int patientId, Date date, double total) {
        this.invoiceId = invoiceId;
        this.patientId = patientId;
        this.date = date;
        this.total = total;
    }

    public int getInvoiceId() { return invoiceId; }
    public void setInvoiceId(int invoiceId) { this.invoiceId = invoiceId; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
