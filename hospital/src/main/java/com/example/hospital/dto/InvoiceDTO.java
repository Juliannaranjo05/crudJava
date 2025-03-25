package com.example.hospital.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class InvoiceDTO {
    private Long invoiceId;
    private Long patientId;
    private LocalDate date;
    private BigDecimal total;

    public InvoiceDTO() {
    }

    public InvoiceDTO(Long invoiceId, Long patientId, LocalDate date, BigDecimal total) {
        this.invoiceId = invoiceId;
        this.patientId = patientId;
        this.date = date;
        this.total = total;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    // Getters y Setters
}
