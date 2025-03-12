package com.sena.crud_basic.service;

import com.sena.crud_basic.DTO.CategoriaDTO;
import com.sena.crud_basic.model.Categoria;
import com.sena.crud_basic.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Obtener todas las categorías
    public List<CategoriaDTO> getAllCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias.stream()
                .map(categoria -> new CategoriaDTO(categoria.getIdCategoria(), categoria.getNombreCategoria()))
                .collect(Collectors.toList());
    }

    // Obtener una categoría por ID
    public Optional<CategoriaDTO> getCategoriaById(int id) {
        return categoriaRepository.findById(id)
                .map(categoria -> new CategoriaDTO(categoria.getIdCategoria(), categoria.getNombreCategoria()));
    }

    // Guardar una nueva categoría
    public CategoriaDTO saveCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setNombreCategoria(categoriaDTO.getNombreCategoria());

        categoria = categoriaRepository.save(categoria);
        return new CategoriaDTO(categoria.getIdCategoria(), categoria.getNombreCategoria());
    }

    // Actualizar una categoría
    public Optional<CategoriaDTO> updateCategoria(int id, CategoriaDTO categoriaDTO) {
        return categoriaRepository.findById(id).map(categoria -> {
            categoria.setNombreCategoria(categoriaDTO.getNombreCategoria());
            Categoria updatedCategoria = categoriaRepository.save(categoria);
            return new CategoriaDTO(updatedCategoria.getIdCategoria(), updatedCategoria.getNombreCategoria());
        });
    }

    // Eliminar una categoría
    public boolean deleteCategoria(int id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}