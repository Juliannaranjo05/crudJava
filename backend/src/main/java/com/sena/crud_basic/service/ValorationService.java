package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.valoration;
import com.sena.crud_basic.model.user;
import com.sena.crud_basic.model.event;
import com.sena.crud_basic.repository.IValorationRepository;
import com.sena.crud_basic.repository.Iuser;
import com.sena.crud_basic.repository.IEventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ValorationService {

    @Autowired
    private IValorationRepository valorationRepository;

    @Autowired
    private Iuser userRepository;

    @Autowired
    private IEventRepository eventRepository;

    // Obtener todos los registros
    public List<valoration> getAll() {
        return valorationRepository.findAll();
    }

    // Obtener por ID
    public Optional<valoration> getById(int id) {
        return valorationRepository.findById(id);
    }

    // Guardar o actualizar con validaciones
    public responseDTO save(valoration valoration) {
        // Validar que el usuario existe
        Optional<user> usuario = userRepository.findById(valoration.getId_user());
        if (!usuario.isPresent()) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "El usuario no existe");
        }

        // Validar que el evento existe
        Optional<event> evento = eventRepository.findById(valoration.getid_event());
        if (!evento.isPresent()) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "El evento no existe");
        }

        // Validar que la puntuación está en el rango de 1 a 5
        if (valoration.get_puntuation() < 1 || valoration.get_puntuation() > 5) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "La puntuación debe estar entre 1 y 5");
        }

        // Validar que la fecha no sea nula
        if (valoration.get_date_valoration() == null) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "La fecha de valoración es obligatoria");
        }

        // Si pasa todas las validaciones, se guarda
        valorationRepository.save(valoration);

        return new responseDTO(
                HttpStatus.OK.toString(),
                "Valoración guardada correctamente");
    }

    // Eliminar por ID
    public responseDTO delete(int id) {
        Optional<valoration> valoracion = valorationRepository.findById(id);
        if (!valoracion.isPresent()) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "La valoración no existe");
        }

        valorationRepository.deleteById(id);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Valoración eliminada correctamente");
    }
}