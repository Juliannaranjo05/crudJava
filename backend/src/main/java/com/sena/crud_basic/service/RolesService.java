package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.roles;
import com.sena.crud_basic.repository.IRolesRepository;
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

    // Guardar o actualizar con validaciones
    public responseDTO save(roles rol) {
        // Validar que el nombre del rol no esté vacío ni nulo
        if (rol.get_name_rol() == null || rol.get_name_rol().trim().isEmpty()) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "El nombre del rol es obligatorio");
        }

        // Validar que el nombre del rol no supere los 50 caracteres
        if (rol.get_name_rol().length() > 50) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "El nombre del rol no puede tener más de 50 caracteres");
        }

        // Guardar el rol si pasa las validaciones
        rolesRepository.save(rol);

        return new responseDTO(
                HttpStatus.OK.toString(),
                "Rol guardado correctamente");
    }

    // Eliminar por ID con validación
    public responseDTO delete(int id) {
        Optional<roles> rol = rolesRepository.findById(id);
        if (!rol.isPresent()) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "El rol no existe");
        }

        rolesRepository.deleteById(id);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Rol eliminado correctamente");
    }
}