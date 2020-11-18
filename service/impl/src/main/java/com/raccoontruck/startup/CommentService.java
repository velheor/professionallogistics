package com.raccoontruck.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService {

    private final CommentRepository commentRepository;

    @Autowired
    CommentService(CommentRepository CommentRepository) {
        this.commentRepository = CommentRepository;
    }

    @Override
    public List<CommentDTO> findAll() {
        return convertToDTO(commentRepository.findAll());
    }

    @Override
    public CommentDTO findById(Long id) {
        return convertToDTO(commentRepository.findById(id).orElse(null));
    }

    @Override
    public CommentDTO update(CommentDTO CommentDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {
        commentRepository.delete(convertFromDTO(findById(id)));
    }

    @Override
    public CommentDTO convertToDTO(Comment comment) {
        return ObjectMapperUtils.map(comment, CommentDTO.class);
    }

    @Override
    public Comment convertFromDTO(CommentDTO commentDTO) {
        return ObjectMapperUtils.map(commentDTO, Comment.class);
    }

    @Override
    public List<CommentDTO> convertToDTO(List<Comment> comments) {
        return ObjectMapperUtils.mapAll(comments, CommentDTO.class);
    }

    @Override
    public List<Comment> convertFromDTO(List<CommentDTO> commentDTOS) {
        return ObjectMapperUtils.mapAll(commentDTOS, Comment.class);
    }
}