package com.example.hospital.service;

import com.example.hospital.model.Prescription;
import com.example.hospital.repository.IPrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionService {

    @Autowired
    private IPrescriptionRepository prescriptionRepository;

    public List<Prescription> findAll() {
        return prescriptionRepository.findAll();
    }

    public Optional<Prescription> findById(Integer id) {
        return prescriptionRepository.findById(id);
    }

    public Prescription save(Prescription prescription) {
        return prescriptionRepository.save(prescription);
    }

    public void deleteById(Integer id) {
        prescriptionRepository.deleteById(id);
    }
}
