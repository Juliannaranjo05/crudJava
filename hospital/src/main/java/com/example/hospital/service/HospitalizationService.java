package com.example.hospital.service;

import com.example.hospital.model.Hospitalization;
import com.example.hospital.repository.IHospitalizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class HospitalizationService {

    @Autowired
    private IHospitalizationRepository hospitalizationRepository;

    public List<Hospitalization> findAll() {
        return hospitalizationRepository.findAll();
    }

    public Optional<Hospitalization> findById(Integer id) {
        return hospitalizationRepository.findById(id);
    }

    public Hospitalization save(Hospitalization hospitalization) {
        return hospitalizationRepository.save(hospitalization);
    }

    public void deleteById(Integer id) {
        hospitalizationRepository.deleteById(id);
    }
}
