package com.sena.crud_basic.service;

import com.sena.crud_basic.DTO.CommentDTO;
import com.sena.crud_basic.model.Comment;
import com.sena.crud_basic.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

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

    // Guardar un comentario
    public CommentDTO saveComment(CommentDTO commentDTO) {
        Comment comment = convertToEntity(commentDTO);
        comment = commentRepository.save(comment);
        return convertToDTO(comment);
    }

    // Eliminar un comentario
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
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