package com.example.hospital.controller;

import com.example.hospital.model.Invoices;
import com.example.hospital.service.InvoicesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoices")
public class InvoicesController {
    private final InvoicesService service;

    public InvoicesController(InvoicesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Invoices> getAllInvoices() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Invoices> getInvoiceById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public Invoices createInvoice(@RequestBody Invoices invoice) {
        return service.save(invoice);
    }

    @DeleteMapping("/{id}")
    public void deleteInvoice(@PathVariable int id) {
        service.deleteById(id);
    }
}
