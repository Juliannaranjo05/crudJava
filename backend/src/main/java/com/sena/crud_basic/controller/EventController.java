package com.sena.crud_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sena.crud_basic.service.EventService;
import com.sena.crud_basic.model.event;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "*")
public class EventController {

    @Autowired
    private EventService eventService;

    // Obtener todos los eventos
    @GetMapping
    public List<event> getAll() {
        return eventService.getAll();
    }

    // Obtener evento por ID
    @GetMapping("/{id}")
    public Optional<event> getById(@PathVariable int id) {
        return eventService.getById(id);
    }

    // Guardar o actualizar evento
    @PostMapping
    public event save(@RequestBody event event) {
        return eventService.save(event);
    }

    // Eliminar evento por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        eventService.delete(id);
    }
}