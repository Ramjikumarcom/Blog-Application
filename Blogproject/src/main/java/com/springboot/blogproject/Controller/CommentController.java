package com.springboot.blogproject.Controller;

import com.springboot.blogproject.Entities.SocialPost;
import com.springboot.blogproject.Payload.CommentDto;
import com.springboot.blogproject.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;
    @PostMapping(path = "/post/{postId}")
    public ResponseEntity<CommentDto>createcomment(@RequestBody CommentDto commentDto, @PathVariable int postId){
        CommentDto commentDto1=commentService.createComment(commentDto,postId);
        return new  ResponseEntity<CommentDto>(commentDto1,HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/delete/{commentId}")
    public  String DeleteComment(@PathVariable int commentId){
        commentService.deleteComment(commentId);
        return "your comment is deleted";
    }


}
