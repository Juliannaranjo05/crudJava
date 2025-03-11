package com.example.hospital.service;

import com.example.hospital.model.Hospitalizations;
import com.example.hospital.repository.HospitalizationsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalizationsService {
    private final HospitalizationsRepository repository;

    public HospitalizationsService(HospitalizationsRepository repository) {
        this.repository = repository;
    }

    public List<Hospitalizations> findAll() {
        return repository.findAll();
    }

    public Optional<Hospitalizations> findById(int id) {
        return repository.findById(id);
    }

    public Hospitalizations save(Hospitalizations hospitalization) {
        return repository.save(hospitalization);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
