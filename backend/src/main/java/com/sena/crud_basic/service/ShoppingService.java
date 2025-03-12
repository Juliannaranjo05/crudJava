package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.crud_basic.repository.IShoppingRepository;
import com.sena.crud_basic.model.shopping;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingService {

    @Autowired
    private IShoppingRepository shoppingRepository;

    // Obtener todos los registros
    public List<shopping> getAll() {
        return shoppingRepository.findAll();
    }

    // Obtener por ID
    public Optional<shopping> getById(int id) {
        return shoppingRepository.findById(id);
    }

    // Guardar o actualizar
    public shopping save(shopping shopping) {
        return shoppingRepository.save(shopping);
    }

    // Eliminar por ID
    public void delete(int id) {
        shoppingRepository.deleteById(id);
    }
}