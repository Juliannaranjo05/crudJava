package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hospital.model.Invoice;

public interface IInvoiceRepository extends JpaRepository<Invoice, Integer> {
}
