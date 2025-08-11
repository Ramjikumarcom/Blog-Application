package com.springboot.blogproject.Service;

import com.springboot.blogproject.Payload.CategoryDto;
import com.springboot.blogproject.Payload.PostDto;
import com.springboot.blogproject.Payload.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

//    create

    PostDto createPost(PostDto postDto,int userId,int CategoryId);

    //    update post
    PostDto updatePost(int PostId, PostDto postDto);

    //    get all post
    PostResponse getAllPost(int pageNumber, int pageSize,String sortBy,String sortDirn);

    //    deletePost
    void deletePost(int PostId);

    //    get single post
    PostDto GetSinglePost(int PostId);




    //    get all category
   List<CategoryDto> getallCategories();

    // search post
    List<PostDto> searchPost(String keyword);

//    get all post by category
    List<PostDto> getAllPostByCategory(int categoryId);


    // get all post by user

    List<PostDto> getAllPostByUser(int userId);
}
