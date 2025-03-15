package com.sena.crud_basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.sena.crud_basic.DTO.responseDTO;
import com.sena.crud_basic.model.payments;
import com.sena.crud_basic.repository.IPaymentsRepository;
import com.sena.crud_basic.repository.IShoppingRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentsService {

    @Autowired
    private IPaymentsRepository paymentsRepository;

    @Autowired
    private IShoppingRepository shoppingRepository; // Repositorio para validar id_shopping

    // Obtener todos los registros
    public List<payments> getAll() {
        return paymentsRepository.findAll();
    }

    // Obtener por ID
    public Optional<payments> getById(int id) {
        return paymentsRepository.findById(id);
    }

    // Guardar o actualizar con validaciones
    public responseDTO save(payments payment) {
        // Validar que la fecha de pago no sea nula
        if (payment.get_date_payment() == null) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "La fecha de pago es obligatoria");
        }

        // Validar que el método de pago sea válido
        List<String> validPaymentMethods = List.of("Efectivo", "Tarjeta", "Transferencia");
        if (!validPaymentMethods.contains(payment.get_payment_method())) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "Método de pago inválido. Debe ser: Efectivo, Tarjeta o Transferencia");
        }

        // Validar que el estado sea válido
        List<String> validStates = List.of("Pendiente", "Pagado", "Rechazado");
        if (!validStates.contains(payment.get_state())) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "Estado inválido. Debe ser: Pendiente, Pagado o Rechazado");
        }

        // Validar que id_shopping exista en la base de datos
        if (!shoppingRepository.existsById(payment.get_id_shopping())) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "El ID de la compra no existe");
        }

        // Guardar el pago si pasa las validaciones
        paymentsRepository.save(payment);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Pago guardado correctamente");
    }

    // Eliminar por ID con validación
    public responseDTO delete(int id) {
        Optional<payments> payment = paymentsRepository.findById(id);
        if (!payment.isPresent()) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "El pago no existe");
        }

        paymentsRepository.deleteById(id);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Pago eliminado correctamente");
    }
}