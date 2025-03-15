package com.sena.crud_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sena.crud_basic.service.EventService;
import com.sena.crud_basic.DTO.responseDTO;
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
    public ResponseEntity<?> save(@RequestBody event event) {
        responseDTO response = eventService.save(event);
        if (response.getStatus().equals(HttpStatus.OK.toString())) {
            return ResponseEntity.ok(response.getMessage());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.getMessage());
        }
    }


    // Eliminar evento por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        eventService.delete(id);
    }
}