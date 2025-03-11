package com.example.hospital.service;

import com.example.hospital.model.patients; 
import com.example.hospital.repository.PatientsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientsService {
    private final PatientsRepository repository;

    public PatientsService(PatientsRepository repository) {
        this.repository = repository;
    }

    public List<patients> findAll() {
        return repository.findAll();
    }

    public Optional<patients> findById(int id) {
        return repository.findById(id);
    }

    public patients save(patients patient) {
        return repository.save(patient);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
