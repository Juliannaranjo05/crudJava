package com.example.hospital.service;

import com.example.hospital.model.Departments;
import com.example.hospital.repository.DepartmentsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentsService {
    private final DepartmentsRepository repository;

    public DepartmentsService(DepartmentsRepository repository) {
        this.repository = repository;
    }

    public List<Departments> findAll() {
        return repository.findAll();
    }

    public Optional<Departments> findById(int id) {
        return repository.findById(id);
    }

    public Departments save(Departments department) {
        return repository.save(department);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
