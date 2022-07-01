package com.remzi.springblogapi.service;

import java.util.List;

import com.remzi.springblogapi.payload.CommentDTO;

public interface CommentService {
    CommentDTO createComment(long postId, CommentDTO commentDTO);

    List<CommentDTO> getCommentsByPostId(long postId);

    CommentDTO getCommentsById(long postId, long id);

    void deleteComment(Long postId, Long commentId);

    CommentDTO updateComment(Long postId, Long commentId, CommentDTO commentDto);
}
