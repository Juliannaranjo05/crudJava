package com.example.hospital.service;

import com.example.hospital.model.Prescriptions;
import com.example.hospital.repository.PrescriptionsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionsService {
    private final PrescriptionsRepository repository;

    public PrescriptionsService(PrescriptionsRepository repository) {
        this.repository = repository;
    }

    public List<Prescriptions> findAll() {
        return repository.findAll();
    }

    public Optional<Prescriptions> findById(int id) {
        return repository.findById(id);
    }

    public Prescriptions save(Prescriptions prescription) {
        return repository.save(prescription);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
