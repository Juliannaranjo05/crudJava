package com.sena.crud_basic.repository;

import com.sena.crud_basic.model.shopping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShoppingRepository extends JpaRepository<shopping, Integer> {
}
