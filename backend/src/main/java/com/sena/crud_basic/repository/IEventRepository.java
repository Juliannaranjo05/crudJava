package com.sena.crud_basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sena.crud_basic.model.event;

public interface IEventRepository extends JpaRepository<event, Integer> {
}