package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.DTO.userDTO;
import com.sena.crud_basic.model.user;
import com.sena.crud_basic.repository.Iuser;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class userService {

    /*
     * save
     * findAll
     * findById
     * Delete
     */
    /* establish connection with the interface */
    @Autowired
    private Iuser data;

    public List<user> findAll() {
        return data.findAll();
    }

    public Optional<user> findById(int id) {
        return data.findById(id);
    }

    public responseDTO deleteUser(int id) {
        if (!findById(id).isPresent()) {
            return new responseDTO(HttpStatus.OK.toString(), "El registro no existe");
        }
        data.deleteById(id);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }

    // register and update
    public responseDTO save(userDTO userDTO) {
        // validación longitud del nombre
        if (userDTO.getNombre().length() < 1 ||
                userDTO.getNombre().length() > 50) {
            responseDTO respuesta = new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "El nombre debe estar entre 1 y 50 caracteres");
            return respuesta;
        }

        // Validar email con regex
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!Pattern.matches(emailRegex, userDTO.getEmail())) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El email no es válido");
        }

        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
        if (!Pattern.matches(passwordRegex, userDTO.getContrasena())) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "La contraseña debe tener al menos 8 caracteres, una mayúscula y un número");
        }
        String telefonoRegex = "^\\d{10}$";
        if (!Pattern.matches(telefonoRegex, userDTO.getTelefono())) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El teléfono debe tener exactamente 10 dígitos numéricos");
        }
        
        // Guardar usuario si pasa las validaciones
        user userRegister = converToModel(userDTO);
        data.save(userRegister);
        return new responseDTO(HttpStatus.OK.toString(), "Se guardó correctamente");
    }

    public userDTO convertToDTO(user user) {
        userDTO userdto = new userDTO(
                user.get_nombre(),
                user.getEmail(),
                user.get_contrasena(),
                user.get_telefono());
        return userdto;
    }

    public user converToModel(userDTO userDTO) {
        user user = new user(
                0,
                userDTO.getNombre(),
                userDTO.getEmail(),
                userDTO.getContrasena(),
                userDTO.getTelefono(),
                LocalDateTime.now());
        return user;
    }

}
