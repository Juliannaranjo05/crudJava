package com.sena.crud_basic.repository;

import com.sena.crud_basic.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    // Puedes agregar consultas personalizadas si lo necesitas
}