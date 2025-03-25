package com.example.hospital.service;

import com.example.hospital.model.Doctor;
import com.example.hospital.repository.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private IDoctorRepository doctorRepository;

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> findById(Integer id) {  // Cambié Long por Integer
        return doctorRepository.findById(id);
    }

    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteById(Integer id) {  // Cambié Long por Integer
        doctorRepository.deleteById(id);
    }
}
