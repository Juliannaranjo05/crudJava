package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.crud_basic.repository.IValorationRepository;
import com.sena.crud_basic.model.valoration;
import java.util.List;
import java.util.Optional;

@Service
public class ValorationService {

    @Autowired
    private IValorationRepository valorationRepository;

    // Obtener todos los registros
    public List<valoration> getAll() {
        return valorationRepository.findAll();
    }

    // Obtener por ID
    public Optional<valoration> getById(int id) {
        return valorationRepository.findById(id);
    }

    // Guardar o actualizar
    public valoration save(valoration valoration) {
        return valorationRepository.save(valoration);
    }

    // Eliminar por ID
    public void delete(int id) {
        valorationRepository.deleteById(id);
    }
}