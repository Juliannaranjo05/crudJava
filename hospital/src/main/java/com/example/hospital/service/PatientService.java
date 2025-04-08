package com.example.hospital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospital.dto.PatientDTO;
import com.example.hospital.model.Patient;
import com.example.hospital.repository.IPatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private IPatientRepository patientRepository;

    //  Método para guardar un paciente con validaciones
    public String save(PatientDTO patientDTO) {
        if (patientDTO.getName().isEmpty() || patientDTO.getName().length() > 100) {
            return "El nombre del paciente debe tener entre 1 y 100 caracteres";
        }

        if (patientDTO.getBirthDate() == null) {
            return "La fecha de nacimiento es obligatoria";
        }

        if (!patientDTO.getGender().matches("Male|Female|Other")) {
            return "El género debe ser Male, Female o Other";
        }

        Patient patient = convertToModel(patientDTO);
        patientRepository.save(patient);
        return "Paciente guardado exitosamente";
    }

    //  Método para obtener todos los pacientes
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    //  Método para buscar un paciente por ID
    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    //  Método para eliminar un paciente por ID
    public String deletePatient(Long id) {
        Optional<Patient> patientOpt = findById(id);
        if (!patientOpt.isPresent()) {
            return "El paciente no existe";
        }

        patientRepository.deleteById(id);
        return "Paciente eliminado correctamente";
    }

    // Método para actualizar un paciente
    public String updatePatient(Long id, PatientDTO patientDTO) {
        Optional<Patient> patientOpt = findById(id); // Buscar al paciente por ID
        
        if (!patientOpt.isPresent()) {
            return "Paciente no encontrado"; // Si no se encuentra el paciente, devolvemos un error
        }

        Patient patient = patientOpt.get(); // Obtenemos el paciente que existe en la base de datos

        // Actualizamos los valores del paciente con los datos nuevos que recibimos en el DTO
        patient.setName(patientDTO.getName());
        patient.setBirthDate(patientDTO.getBirthDate());
        patient.setGender(patientDTO.getGender());
        patient.setPhone(patientDTO.getPhone());
        patient.setAddress(patientDTO.getAddress());

        // Guardamos el paciente actualizado en la base de datos
        patientRepository.save(patient);
        return "Paciente actualizado correctamente"; // Confirmamos que se actualizó
    }

    // Métodos para convertir entre DTO y Modelo
    public PatientDTO convertToDTO(Patient patient) {
        return new PatientDTO(
                patient.getName(),
                patient.getBirthDate(),
                patient.getGender(),
                patient.getPhone(),
                patient.getAddress()
        );
    }

    public Patient convertToModel(PatientDTO patientDTO) {
        return new Patient(
                null,
                patientDTO.getName(),
                patientDTO.getBirthDate(),
                patientDTO.getGender(),
                patientDTO.getPhone(),
                patientDTO.getAddress()
        );
    }
}
