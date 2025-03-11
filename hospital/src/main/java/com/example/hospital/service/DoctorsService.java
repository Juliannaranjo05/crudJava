package com.example.hospital.service;

import com.example.hospital.model.Doctors;
import com.example.hospital.repository.DoctorsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorsService {
    private final DoctorsRepository repository;

    public DoctorsService(DoctorsRepository repository) {
        this.repository = repository;
    }

    public List<Doctors> findAll() {
        return repository.findAll();
    }

    public Optional<Doctors> findById(int id) {
        return repository.findById(id);
    }

    public Doctors save(Doctors doctor) {
        return repository.save(doctor);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
