package com.springboot.blogproject.ServiceImpl;

import com.springboot.blogproject.Entities.CommentEntity;
import com.springboot.blogproject.Entities.SocialPost;
import com.springboot.blogproject.Exception.CategoryNotFoundException;
import com.springboot.blogproject.Payload.CommentDto;
import com.springboot.blogproject.Repository.CommentRepo;
import com.springboot.blogproject.Repository.PostRepo;
import com.springboot.blogproject.Service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostRepo socialPostRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
     private  CommentRepo commentRepo;
    @Override
    public CommentDto createComment(CommentDto commentDto, int PostId) {
        SocialPost socialPost= socialPostRepo.findById(PostId).orElseThrow(()-> new CategoryNotFoundException("cId","Cid",PostId));
        CommentEntity commentEntity =modelMapper.map(commentDto, CommentEntity.class);

        commentEntity.setSocialPost(socialPost);


        CommentEntity savedCommentEntity = commentRepo.save(commentEntity);
        System.out.println(savedCommentEntity);
   commentDto=modelMapper.map(savedCommentEntity, CommentDto.class);
        System.out.println(commentDto);
        return commentDto ;
    }

    @Override
    public void deleteComment(int commentId) {
        CommentEntity commentEntity= commentRepo.findById(commentId).orElseThrow(()-> new CategoryNotFoundException("cId","Cid",commentId));
       commentRepo.delete(commentEntity);
    }
}
