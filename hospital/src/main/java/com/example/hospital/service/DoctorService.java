package com.example.hospital.service;

import com.example.hospital.dto.DoctorDTO;
import com.example.hospital.model.Doctor;
import com.example.hospital.repository.IDoctorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private IDoctorRepository doctorRepository;

    // Obtener todos los doctores
    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll()
                               .stream()
                               .map(this::convertToDTO)
                               .collect(Collectors.toList());
    }

    // Obtener doctor por ID
    public Optional<DoctorDTO> getDoctorById(Long id) {
        return doctorRepository.findById(id)
                               .map(this::convertToDTO);
    }

    // Crear nuevo doctor
    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = convertToEntity(doctorDTO);
        doctor = doctorRepository.save(doctor);
        return convertToDTO(doctor);
    }

    // Actualizar doctor
    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) {
        if (doctorRepository.existsById(id)) {
            Doctor doctor = convertToEntity(doctorDTO);
            doctor.setDoctorId(id);
            doctor = doctorRepository.save(doctor);
            return convertToDTO(doctor);
        }
        return null; // O puedes lanzar una excepción si lo prefieres
    }

    // Eliminar doctor
    public boolean deleteDoctor(Long id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Convertir de entidad a DTO
    private DoctorDTO convertToDTO(Doctor doctor) {
        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setDoctorId(doctor.getDoctorId());
        doctorDTO.setName(doctor.getName());
        doctorDTO.setSpecialty(doctor.getSpecialty());
        doctorDTO.setPhone(doctor.getPhone());
        doctorDTO.setEmail(doctor.getEmail());
        return doctorDTO;
    }

    // Convertir de DTO a entidad
    private Doctor convertToEntity(DoctorDTO doctorDTO) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorDTO.getName());
        doctor.setSpecialty(doctorDTO.getSpecialty());
        doctor.setPhone(doctorDTO.getPhone());
        doctor.setEmail(doctorDTO.getEmail());
        return doctor;
    }
}
