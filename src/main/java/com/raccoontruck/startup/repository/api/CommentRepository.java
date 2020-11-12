package com.raccoontruck.startup.repository.api;

import com.raccoontruck.startup.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}