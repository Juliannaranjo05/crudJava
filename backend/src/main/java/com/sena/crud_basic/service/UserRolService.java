package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.sena.crud_basic.DTO.UserRolDTO;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.user_rol;
import com.sena.crud_basic.model.user;
import com.sena.crud_basic.repository.IUserRolRepository;
import com.sena.crud_basic.repository.Iuser;

@Service
public class UserRolService {

    @Autowired
    private IUserRolRepository userRolRepository;

    @Autowired
    private Iuser userRepository; // Necesario para buscar el usuario

    public responseDTO save(UserRolDTO userRolDTO) {
        // Validación de id_rol
        if (userRolDTO.getIdRol() <= 0) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "El id del rol debe ser mayor a 0");
        }

        // Validación de id_usuario
        user usuario = userRepository.findById(userRolDTO.getIdUsuario())
                .orElse(null);

        if (usuario == null) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "El usuario no existe");
        }

        // Si pasa todas las validaciones, se guarda
        user_rol userRol = new user_rol(
                userRolDTO.getIdUserRol(),
                usuario,
                userRolDTO.getIdRol());

        userRolRepository.save(userRol);

        return new responseDTO(
                HttpStatus.OK.toString(),
                "Se guardó correctamente el rol del usuario");
    }

    public UserRolDTO convertToDTO(user_rol userRol) {
        return new UserRolDTO(
                userRol.getIdUserRol(),
                userRol.getUser().getId_usuario(), // Convertir objeto user a id
                userRol.getIdRol());
    }

    public user_rol convertToModel(UserRolDTO userRolDTO) {
        user usuario = userRepository.findById(userRolDTO.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return new user_rol(
                userRolDTO.getIdUserRol(),
                usuario,
                userRolDTO.getIdRol());
    }
}