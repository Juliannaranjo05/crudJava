package com.example.hospital.service;

import com.example.hospital.model.Medication;
import com.example.hospital.repository.IMedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MedicationService {

    @Autowired
    private IMedicationRepository medicationRepository;

    public List<Medication> findAll() {
        return medicationRepository.findAll();
    }

    public Optional<Medication> findById(Integer id) {
        return medicationRepository.findById(id);
    }

    public Medication save(Medication medication) {
        return medicationRepository.save(medication);
    }

    public void deleteById(Integer id) {
        medicationRepository.deleteById(id);
    }
}
