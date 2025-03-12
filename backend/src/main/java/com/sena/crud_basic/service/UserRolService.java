package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.UserRolDTO;
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

    public void save(UserRolDTO userRolDTO) {
        user_rol userRol = convertToModel(userRolDTO);
        userRolRepository.save(userRol);
    }

    public UserRolDTO convertToDTO(user_rol userRol) {
        return new UserRolDTO(
                userRol.getIdUserRol(),
                userRol.getUser().getId_usuario(), // Convertir objeto user a id
                userRol.getIdRol());
    }

    public user_rol convertToModel(UserRolDTO userRolDTO) {
        user user = userRepository.findById(userRolDTO.getIdUsuario())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        return new user_rol(
            userRolDTO.getIdUserRol(),
            user, // Pasar el objeto `user` en lugar de `idUsuario`
            userRolDTO.getIdRol());
    }
}