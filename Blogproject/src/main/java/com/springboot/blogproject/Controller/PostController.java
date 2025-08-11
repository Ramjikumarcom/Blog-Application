package com.springboot.blogproject.Controller;

import com.springboot.blogproject.Config.AppConstant;
import com.springboot.blogproject.Payload.PostDto;
import com.springboot.blogproject.Payload.PostResponse;
import com.springboot.blogproject.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.springboot.blogproject.Config.AppConstant.PAGE_NUMBER;

@RestController
@RequestMapping(path = "/api")
public class PostController {

@Autowired
   PostService postService;

    @PostMapping(path = "/userid/{userId}/categoryid/{categoryId}/post")
    public ResponseEntity< PostDto> createPost(@RequestBody PostDto postDto, @PathVariable int userId, @PathVariable int categoryId){
      PostDto postDto1=  postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<PostDto>(postDto1, HttpStatus.CREATED);
    }

    @GetMapping(path ="/posts" )
    public ResponseEntity<PostResponse>getallPost(
            @RequestParam(value = "pageNumber",defaultValue = AppConstant.PAGE_NUMBER,required = false) int pageNumber,
            @RequestParam(value="PageSize",defaultValue = AppConstant.PAGE_SIZE,required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = AppConstant.SORT_BY,required = false) String sortBy,
            @RequestParam(value = "sortDirn",defaultValue = AppConstant.SORT_DIRN,required = false)  String sortDirn
    ){
        PostResponse postResponse=postService.getAllPost(
                pageNumber,pageSize, sortBy, sortDirn);
        return ResponseEntity.ok(postResponse);
    }
    @GetMapping(path = "/{postId}")
    public ResponseEntity<PostDto>getPostById(@PathVariable int postId){
       PostDto postDto= postService.GetSinglePost(postId);
       return  ResponseEntity.ok(postDto);

    }

  @PutMapping(path = "/update/{postId}")
  public ResponseEntity<PostDto>updatepost( @PathVariable  int postId, @RequestBody PostDto postDto){
     postDto= postService.updatePost(postId,postDto);
     return ResponseEntity.ok(postDto);
  }

  @GetMapping(path = "/post/categories/{categoryId}")
  public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable int categoryId){
       List<PostDto> postDto=postService.getAllPostByCategory(categoryId);
       return  ResponseEntity.ok(postDto);
  }
@GetMapping(path = "/post/user/{userId}")
public ResponseEntity<List<PostDto>>getPostByUser(@PathVariable int userId){
        List<PostDto>postDtos = postService.getAllPostByUser(userId);
        return ResponseEntity.ok(postDtos);
}

@GetMapping(path = "/search/{keyword}")
public  ResponseEntity<List<PostDto>>searchPostTitle(@PathVariable String  keyword){
        List<PostDto> postDtos=postService.searchPost(keyword);
        return  ResponseEntity.ok(postDtos);
}



    @DeleteMapping(path = "/delete/{postId}")
    public  String DeletePost(@PathVariable int postId){
        postService.deletePost(postId);
        return "post is deleted succsefully";
    }




}
