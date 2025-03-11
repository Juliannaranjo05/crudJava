package com.example.hospital.service;

import com.example.hospital.model.Rooms;
import com.example.hospital.repository.RoomsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoomsService {
    private final RoomsRepository repository;

    public RoomsService(RoomsRepository repository) {
        this.repository = repository;
    }

    public List<Rooms> findAll() {
        return repository.findAll();
    }

    public Optional<Rooms> findById(int id) {
        return repository.findById(id);
    }

    public Rooms save(Rooms room) {
        return repository.save(room);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
