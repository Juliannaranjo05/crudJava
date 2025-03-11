package com.example.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hospital.model.Invoices;

public interface InvoicesRepository extends JpaRepository
<Invoices, Integer>
{

}
