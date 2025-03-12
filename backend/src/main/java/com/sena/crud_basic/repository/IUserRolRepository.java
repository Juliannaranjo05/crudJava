package com.sena.crud_basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sena.crud_basic.model.user_rol;

public interface IUserRolRepository extends JpaRepository<user_rol, Integer> {
    
    /*
     * Métodos para operaciones CRUD
     */

}