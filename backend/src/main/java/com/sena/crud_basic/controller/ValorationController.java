package com.sena.crud_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sena.crud_basic.service.ValorationService;
import com.sena.crud_basic.model.valoration;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/valoration")
public class ValorationController {

    @Autowired
    private ValorationService valorationService;

    // Obtener todas las valoraciones
    @GetMapping
    public List<valoration> getAll() {
        return valorationService.getAll();
    }

    // Obtener una valoración por ID
    @GetMapping("/{id}")
    public Optional<valoration> getById(@PathVariable int id) {
        return valorationService.getById(id);
    }

    // Crear o actualizar una valoración
    @PostMapping
    public valoration save(@RequestBody valoration valoration) {
        return valorationService.save(valoration);
    }

    // Eliminar una valoración por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        valorationService.delete(id);
    }
}