package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.crud_basic.repository.IPaymentsRepository;
import com.sena.crud_basic.model.payments;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentsService {

    @Autowired
    private IPaymentsRepository paymentsRepository;

    // Obtener todos los registros
    public List<payments> getAll() {
        return paymentsRepository.findAll();
    }

    // Obtener por ID
    public Optional<payments> getById(int id) {
        return paymentsRepository.findById(id);
    }

    // Guardar o actualizar
    public payments save(payments payments) {
        return paymentsRepository.save(payments);
    }

    // Eliminar por ID
    public void delete(int id) {
        paymentsRepository.deleteById(id);
    }
}