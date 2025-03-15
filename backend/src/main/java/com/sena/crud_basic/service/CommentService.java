package com.sena.crud_basic.service;

import com.sena.crud_basic.DTO.CommentDTO;
import com.sena.crud_basic.model.Comment;
import com.sena.crud_basic.repository.CommentRepository;
import com.sena.crud_basic.repository.IEventRepository;
import com.sena.crud_basic.repository.Iuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private IEventRepository eventRepository; // Para validar existencia de evento

    @Autowired
    private Iuser userRepository; // Para validar existencia de usuario

    // Obtener todos los comentarios
    public List<CommentDTO> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Obtener un comentario por ID
    public Optional<CommentDTO> getCommentById(int id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.map(this::convertToDTO);
    }

    // Guardar un comentario con validaciones
    public CommentDTO saveComment(CommentDTO commentDTO) {
        validateComment(commentDTO);
        Comment comment = convertToEntity(commentDTO);
        comment = commentRepository.save(comment);
        return convertToDTO(comment);
    }

    // Eliminar un comentario
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }

    // Validar los datos antes de guardarlos
    private void validateComment(CommentDTO commentDTO) {
        if (!eventRepository.existsById(commentDTO.getId_event())) {
            throw new IllegalArgumentException("El evento con ID " + commentDTO.getId_event() + " no existe.");
        }
        if (!userRepository.existsById(commentDTO.getId_user())) {
            throw new IllegalArgumentException("El usuario con ID " + commentDTO.getId_user() + " no existe.");
        }
        if (commentDTO.getComment() == null || commentDTO.getComment().trim().isEmpty()) {
            throw new IllegalArgumentException("El comentario no puede estar vacío.");
        }
        if (commentDTO.getComment().length() > 500) {
            throw new IllegalArgumentException("El comentario no puede tener más de 500 caracteres.");
        }
        if (commentDTO.getDate_comment() == null) {
            throw new IllegalArgumentException("La fecha del comentario no puede ser nula.");
        }
    }

    // Convertir de Entity a DTO
    private CommentDTO convertToDTO(Comment comment) {
        return new CommentDTO(comment.getId_comment(), comment.getId_user(), comment.getId_event(), comment.getComment(), comment.getDate_comment());
    }

    // Convertir de DTO a Entity
    private Comment convertToEntity(CommentDTO commentDTO) {
        return new Comment(commentDTO.getId_comment(), commentDTO.getId_user(), commentDTO.getId_event(), commentDTO.getComment(), commentDTO.getDate_comment());
    }
}