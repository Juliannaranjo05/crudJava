package com.sena.crud_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sena.crud_basic.service.PaymentsService;
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
    public payments save(@RequestBody payments payments) {
        return paymentsService.save(payments);
    }

    // Eliminar por ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        paymentsService.delete(id);
    }
}