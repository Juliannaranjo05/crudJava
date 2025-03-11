package com.example.hospital.service;

import com.example.hospital.model.Medications;
import com.example.hospital.repository.MedicationsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MedicationsService {
    private final MedicationsRepository repository;

    public MedicationsService(MedicationsRepository repository) {
        this.repository = repository;
    }

    public List<Medications> findAll() {
        return repository.findAll();
    }

    public Optional<Medications> findById(int id) {
        return repository.findById(id);
    }

    public Medications save(Medications medication) {
        return repository.save(medication);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
