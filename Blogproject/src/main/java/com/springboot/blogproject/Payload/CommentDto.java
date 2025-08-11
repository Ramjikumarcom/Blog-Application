package com.springboot.blogproject.Payload;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CommentDto {


    private  int commentId;
    private String message;

    public CommentDto() {
    }

    public CommentDto(int commentId, String message) {
        this.commentId = commentId;
        this.message = message;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Comment:{" +
                "commentId=" + commentId +
                ", message='" + message + '\'' +
                '}';
    }
}
