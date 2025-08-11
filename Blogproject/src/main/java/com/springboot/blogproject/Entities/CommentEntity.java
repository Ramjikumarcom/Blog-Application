package com.springboot.blogproject.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int commentId;
    private String message;

    @ManyToOne
    @JoinColumn(name = "postId")
    private SocialPost socialPost;

    public CommentEntity() {
    }

    public CommentEntity(int commentId, String message, SocialPost socialPost) {
        this.commentId = commentId;
        this.message = message;
        this.socialPost = socialPost;
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

    public SocialPost getSocialPost() {
        return socialPost;
    }

    public void setSocialPost(SocialPost socialPost) {
        this.socialPost = socialPost;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "commentId=" + commentId +
                ", message='" + message + '\'' +
                ", socialPost=" + socialPost +
                '}';
    }
}
