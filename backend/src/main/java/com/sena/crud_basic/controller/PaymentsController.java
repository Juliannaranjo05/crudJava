package com.sena.crud_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sena.crud_basic.service.PaymentsService;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.payments;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "*")
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

    // Obtener todos los registros
    @GetMapping
    public List<payments> getAll() {
        return paymentsService.getAll();
    }

    // Obtener por ID
    @GetMapping("/{id}")
    public Optional<payments> getById(@PathVariable int id) {
        return paymentsService.getById(id);
    }

    // Guardar o actualizar
    @PostMapping
    public ResponseEntity<?> save(@RequestBody payments payment) {
        responseDTO response = paymentsService.save(payment);
        if (response.getStatus().equals(HttpStatus.OK.toString())) {
            return ResponseEntity.ok(response.getMessage());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.getMessage());
        }
    }

    // Eliminar por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        paymentsService.delete(id);
    }
}