package com.sena.crud_basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sena.crud_basic.model.roles;

public interface IRolesRepository extends JpaRepository<roles, Integer> {
}
