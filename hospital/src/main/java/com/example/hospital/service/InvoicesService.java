package com.example.hospital.service;

import com.example.hospital.model.Invoices;
import com.example.hospital.repository.InvoicesRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InvoicesService {
    private final InvoicesRepository repository;

    public InvoicesService(InvoicesRepository repository) {
        this.repository = repository;
    }

    public List<Invoices> findAll() {
        return repository.findAll();
    }

    public Optional<Invoices> findById(int id) {
        return repository.findById(id);
    }

    public Invoices save(Invoices invoice) {
        return repository.save(invoice);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
