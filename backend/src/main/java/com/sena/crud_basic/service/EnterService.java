package com.sena.crud_basic.service;

import com.sena.crud_basic.DTO.EnterDTO;
import com.sena.crud_basic.model.Enter;
import com.sena.crud_basic.repository.EnterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnterService {

    @Autowired
    private EnterRepository enterRepository;

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

    // Guardar una nueva entrada
    public EnterDTO saveEnter(EnterDTO enterDTO) {
        Enter enter = convertToEntity(enterDTO);
        enter = enterRepository.save(enter);
        return convertToDTO(enter);
    }

    // Eliminar una entrada
    public void deleteEnter(int id) {
        enterRepository.deleteById(id);
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