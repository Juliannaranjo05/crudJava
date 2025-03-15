package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.shopping;
import com.sena.crud_basic.model.user;
import com.sena.crud_basic.model.Enter;
import com.sena.crud_basic.repository.IShoppingRepository;
import com.sena.crud_basic.repository.Iuser;
import com.sena.crud_basic.repository.EnterRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingService {

    @Autowired
    private IShoppingRepository shoppingRepository;

    @Autowired
    private Iuser userRepository;

    @Autowired
    private EnterRepository enterpriseRepository;

    // Obtener todos los registros
    public List<shopping> getAll() {
        return shoppingRepository.findAll();
    }

    // Obtener por ID
    public Optional<shopping> getById(int id) {
        return shoppingRepository.findById(id);
    }

    // Guardar o actualizar con validaciones
    public responseDTO save(shopping shopping) {
        // Validar que el usuario existe
        Optional<user> usuario = userRepository.findById(shopping.getId_user());
        if (!usuario.isPresent()) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "El usuario no existe");
        }

        // Validar que la empresa existe
        Optional<Enter> empresa = enterpriseRepository.findById(shopping.getId_enter());
        if (!empresa.isPresent()) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "La empresa no existe");
        }

        // Validar que la cantidad es positiva
        if (shopping.get_amount() <= 0) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "El monto debe ser un valor positivo");
        }

        // Validar que la fecha de compra no sea nula
        if (shopping.get_date_shopping() == null) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "La fecha de compra es obligatoria");
        }

        // Si pasa todas las validaciones, se guarda
        shoppingRepository.save(shopping);

        return new responseDTO(
                HttpStatus.OK.toString(),
                "Compra guardada correctamente");
    }

    // Eliminar por ID con validación
    public responseDTO delete(int id) {
        Optional<shopping> compra = shoppingRepository.findById(id);
        if (!compra.isPresent()) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "La compra no existe");
        }

        shoppingRepository.deleteById(id);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Compra eliminada correctamente");
    }
}