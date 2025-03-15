package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.event;
import com.sena.crud_basic.repository.IEventRepository;
import com.sena.crud_basic.repository.Iuser;
import com.sena.crud_basic.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private IEventRepository eventRepository;

    @Autowired
    private Iuser userRepository; // Para validar id_organizer

    @Autowired
    private CategoriaRepository categoryRepository; // Para validar id_category

    // Obtener todos los eventos
    public List<event> getAll() {
        return eventRepository.findAll();
    }

    // Obtener evento por ID
    public Optional<event> getById(int id) {
        return eventRepository.findById(id);
    }

    // Guardar o actualizar evento con validaciones
    public responseDTO save(event evento) {
        // Validar que el título no sea nulo ni vacío
        if (evento.get_title() == null || evento.get_title().trim().isEmpty()) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "El título del evento es obligatorio");
        }

        // Validar que la descripción tenga al menos 10 caracteres
        if (evento.get_description() == null || evento.get_description().length() < 10) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "La descripción debe tener al menos 10 caracteres");
        }

        // Validar que la ubicación no sea nula ni vacía
        if (evento.get_ubication() == null || evento.get_ubication().trim().isEmpty()) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "La ubicación del evento es obligatoria");
        }

        // Validar que el organizador exista
        if (!userRepository.existsById(evento.getId_organizer())) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "El organizador no existe");
        }

        // Validar que la categoría exista
        if (!categoryRepository.existsById(evento.getId_category())) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "La categoría no existe");
        }

        // Guardar evento si pasa las validaciones
        eventRepository.save(evento);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Evento guardado correctamente");
    }

    // Eliminar evento por ID con validación
    public responseDTO delete(int id) {
        Optional<event> evento = eventRepository.findById(id);
        if (!evento.isPresent()) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "El evento no existe");
        }

        eventRepository.deleteById(id);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Evento eliminado correctamente");
    }
}