package com.springboot.blogproject.Service;

import com.springboot.blogproject.Payload.CommentDto;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {

    CommentDto createComment(CommentDto commentDto,int PostId);
    void deleteComment(int commentId);
}
