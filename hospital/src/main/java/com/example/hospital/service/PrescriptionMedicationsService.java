package com.example.hospital.service;

import com.example.hospital.model.PrescriptionMedications;
import com.example.hospital.repository.PrescriptionMedicationsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionMedicationsService {
    private final PrescriptionMedicationsRepository repository;

    public PrescriptionMedicationsService(PrescriptionMedicationsRepository repository) {
        this.repository = repository;
    }

    public List<PrescriptionMedications> findAll() {
        return repository.findAll();
    }

    public Optional<PrescriptionMedications> findById(int id) {
        return repository.findById(id);
    }

    public PrescriptionMedications save(PrescriptionMedications prescriptionMedication) {
        return repository.save(prescriptionMedication);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
