package com.sena.crud_basic.controller;

import com.sena.crud_basic.DTO.EnterDTO;
import com.sena.crud_basic.service.EnterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enter")
@CrossOrigin(origins = "*")
public class EnterController {

    @Autowired
    private EnterService enterService;

    // Obtener todas las entradas
    @GetMapping
    public List<EnterDTO> getAllEnters() {
        return enterService.getAllEnters();
    }

    // Obtener una entrada por ID
    @GetMapping("/{id}")
    public ResponseEntity<EnterDTO> getEnterById(@PathVariable int id) {
        Optional<EnterDTO> enter = enterService.getEnterById(id);
        return enter.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear una nueva entrada
    @PostMapping
    public ResponseEntity<EnterDTO> createEnter(@RequestBody EnterDTO enterDTO) {
        EnterDTO savedEnter = enterService.saveEnter(enterDTO);
        return ResponseEntity.ok(savedEnter);
    }

    // Eliminar una entrada
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnter(@PathVariable int id) {
        enterService.deleteEnter(id);
        return ResponseEntity.noContent().build();
    }
}