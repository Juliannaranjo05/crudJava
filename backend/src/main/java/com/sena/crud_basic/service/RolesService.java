package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.crud_basic.repository.IRolesRepository;
import com.sena.crud_basic.model.roles;
import java.util.List;
import java.util.Optional;

@Service
public class RolesService {

    @Autowired
    private IRolesRepository rolesRepository;

    // Obtener todos los registros
    public List<roles> getAll() {
        return rolesRepository.findAll();
    }

    // Obtener por ID
    public Optional<roles> getById(int id) {
        return rolesRepository.findById(id);
    }

    // Guardar o actualizar
    public roles save(roles roles) {
        return rolesRepository.save(roles);
    }

    // Eliminar por ID
    public void delete(int id) {
        rolesRepository.deleteById(id);
    }
}