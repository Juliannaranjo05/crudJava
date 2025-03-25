package com.example.hospital.service;

import com.example.hospital.model.PrescriptionMedication;
import com.example.hospital.model.PrescriptionMedicationId;
import com.example.hospital.repository.IPrescriptionMedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PrescriptionMedicationService {

    @Autowired
    private IPrescriptionMedicationRepository prescriptionMedicationRepository;

    public List<PrescriptionMedication> findAll() {
        return prescriptionMedicationRepository.findAll();
    }

    public Optional<PrescriptionMedication> findById(PrescriptionMedicationId id) {
        return prescriptionMedicationRepository.findById(id);
    }

    public PrescriptionMedication save(PrescriptionMedication prescriptionMedication) {
        return prescriptionMedicationRepository.save(prescriptionMedication);
    }

    public void deleteById(PrescriptionMedicationId id) {
        prescriptionMedicationRepository.deleteById(id);
    }
}
