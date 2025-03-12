package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.crud_basic.repository.IEventRepository;
import com.sena.crud_basic.model.event;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private IEventRepository eventRepository;

    // Obtener todos los eventos
    public List<event> getAll() {
        return eventRepository.findAll();
    }

    // Obtener evento por ID
    public Optional<event> getById(int id) {
        return eventRepository.findById(id);
    }

    // Guardar o actualizar evento
    public event save(event event) {
        return eventRepository.save(event);
    }

    // Eliminar evento por ID
    public void delete(int id) {
        eventRepository.deleteById(id);
    }
}