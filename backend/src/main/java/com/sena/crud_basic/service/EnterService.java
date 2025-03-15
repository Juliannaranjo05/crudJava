package com.sena.crud_basic.service;

import com.sena.crud_basic.DTO.EnterDTO;
import com.sena.crud_basic.model.Enter;
import com.sena.crud_basic.repository.EnterRepository;
import com.sena.crud_basic.repository.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnterService {

    @Autowired
    private EnterRepository enterRepository;

    @Autowired
    private IEventRepository eventRepository; // Para validar que el evento existe

    // Obtener todas las entradas
    public List<EnterDTO> getAllEnters() {
        List<Enter> enters = enterRepository.findAll();
        return enters.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Obtener una entrada por ID
    public Optional<EnterDTO> getEnterById(int id) {
        Optional<Enter> enter = enterRepository.findById(id);
        return enter.map(this::convertToDTO);
    }

    // Guardar una nueva entrada con validaciones
    public EnterDTO saveEnter(EnterDTO enterDTO) {
        validateEnter(enterDTO);
        Enter enter = convertToEntity(enterDTO);
        enter = enterRepository.save(enter);
        return convertToDTO(enter);
    }

    // Eliminar una entrada
    public void deleteEnter(int id) {
        enterRepository.deleteById(id);
    }

    // Validar datos de la entrada antes de guardarla
    private void validateEnter(EnterDTO enterDTO) {
        if (!eventRepository.existsById(enterDTO.getId_event())) {
            throw new IllegalArgumentException("El evento con ID " + enterDTO.getId_event() + " no existe.");
        }
        if (enterDTO.getPrice() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }
        if (enterDTO.getAvailable_quantity() < 0) {
            throw new IllegalArgumentException("La cantidad disponible no puede ser negativa.");
        }
    }

    // Convertir de Entity a DTO
    private EnterDTO convertToDTO(Enter enter) {
        return new EnterDTO(enter.getId_enter(), enter.getId_event(), enter.getPrice(), enter.getAvailable_quantity());
    }

    // Convertir de DTO a Entity
    private Enter convertToEntity(EnterDTO enterDTO) {
        return new Enter(enterDTO.getId_enter(), enterDTO.getId_event(), enterDTO.getPrice(), enterDTO.getAvailable_quantity());
    }
}