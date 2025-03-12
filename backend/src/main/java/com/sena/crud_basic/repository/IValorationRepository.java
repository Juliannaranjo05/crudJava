package com.sena.crud_basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sena.crud_basic.model.valoration;

public interface IValorationRepository extends JpaRepository<valoration, Integer> {
}