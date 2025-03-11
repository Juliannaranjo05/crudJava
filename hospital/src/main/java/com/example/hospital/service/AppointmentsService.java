package com.example.hospital.service;

import com.example.hospital.model.Appointments;
import com.example.hospital.repository.AppointmentsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentsService {
    private final AppointmentsRepository repository;

    public AppointmentsService(AppointmentsRepository repository) {
        this.repository = repository;
    }

    public List<Appointments> findAll() {
        return repository.findAll();
    }

    public Optional<Appointments> findById(int id) {
        return repository.findById(id);
    }

    public Appointments save(Appointments appointment) {
        return repository.save(appointment);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
