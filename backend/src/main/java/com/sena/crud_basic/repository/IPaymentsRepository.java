package com.sena.crud_basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sena.crud_basic.model.payments;

public interface IPaymentsRepository extends JpaRepository<payments, Integer> {
}