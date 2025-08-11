package com.springboot.blogproject.ServiceImpl;

import com.springboot.blogproject.Entities.Categories;
import com.springboot.blogproject.Entities.SocialPost;
import com.springboot.blogproject.Entities.User;
import com.springboot.blogproject.Exception.CategoryNotFoundException;
import com.springboot.blogproject.Exception.UserNotFoundException;
import com.springboot.blogproject.Payload.*;
import com.springboot.blogproject.Repository.CategoryRepo;
import com.springboot.blogproject.Repository.PostRepo;
import com.springboot.blogproject.Repository.UserRepo;
import com.springboot.blogproject.Service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postRepo;

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepo userRepo;

    public PostDto createPost(PostDto postDto, int userId, int categoryId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User", "userId", userId));
        Categories category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new UserNotFoundException("Category", "categoryId", categoryId));

        SocialPost socialPost = modelMapper.map(postDto, SocialPost.class);
        socialPost.setImageName("default.png");
        socialPost.setCurrrentDate(new Date());
        socialPost.setCategories(category);
        socialPost.setUser(user);

        socialPost = postRepo.save(socialPost);

        PostDto savedPostDto = modelMapper.map(socialPost, PostDto.class);

        savedPostDto.setCategoryDto(modelMapper.map(category, CategoryDto.class));
        savedPostDto.setUserDto(modelMapper.map(user, UserDto.class));

        return savedPostDto;
    }

    @Override
    public PostDto updatePost(int PostId, PostDto postDto) {
        SocialPost socialPost = postRepo.findById(PostId).
                orElseThrow(() -> new CategoryNotFoundException("category", "category Id", PostId));
        socialPost.setPostContent(postDto.getPostContent());
        socialPost.setImageName(postDto.getImageName());
        socialPost.setTitle(postDto.getTitle());
        socialPost.setCurrrentDate(postDto.getCurrrentDate());

        postRepo.save(socialPost);

        System.out.println(socialPost);

        PostDto postDto1=modelMapper.map(socialPost, PostDto.class);
        postDto1.setUserDto(modelMapper.map(socialPost.getUser(),UserDto.class));
        postDto1.setCategoryDto(modelMapper.map(socialPost.getCategories(),CategoryDto.class));
        System.out.println(postDto1);
        return postDto1;
    }

    @Override
    public PostResponse getAllPost(int pageNumber,int pageSize,String sortBy,String sortDirn) {
//        List<SocialPost> socialPosts = postRepo.findAll();
//        System.out.println(socialPosts);

        Sort sort=null;
        if(sortDirn.equalsIgnoreCase("asc")) sort=sort.by(sortBy).ascending();
        else {
            sort=sort.by(sortBy).descending();
        }

        Pageable pageable =  PageRequest.of(pageNumber,pageSize,sort);
        Page<SocialPost>pagePost=postRepo.findAll( pageable);
        List<SocialPost>allPosts=pagePost.getContent(); //With pageNumber = 1 and pageSize = 10, this retrieves posts 11 to 20.
       // The allPosts list will contain these 10 posts.

        List<PostDto> postDtos = allPosts.stream().map((socialPostData) -> {
            PostDto postDto = modelMapper.map(socialPostData, PostDto.class);

            postDto.setCategoryDto(modelMapper.map(socialPostData.getCategories(), CategoryDto.class));
            postDto.setUserDto(modelMapper.map(socialPostData.getUser(), UserDto.class));

            return postDto;
        }).collect(Collectors.toList());

//      System.out.println(postDtos);
        PostResponse postResponse=new PostResponse();
        postResponse.setContent(postDtos);


        postResponse.setLastPage(pagePost.isLast());
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setTotalElements(pagePost.getNumberOfElements());






        return postResponse;
    }


    @Override
    public void deletePost(int PostId) {
        SocialPost socialPost = postRepo.findById(PostId).
                orElseThrow(() -> new CategoryNotFoundException("category", "category Id", PostId));
        postRepo.delete(socialPost);



    }

    @Override
    public PostDto GetSinglePost(int PostId) {
        SocialPost socialPost = postRepo.findById(PostId).
                orElseThrow(() -> new CategoryNotFoundException("category", "category Id", PostId));

       PostDto postDto=  modelMapper.map(socialPost,PostDto.class);
       postDto.setCategoryDto(modelMapper.map(socialPost.getCategories(),CategoryDto.class));
       postDto.setUserDto(modelMapper.map(socialPost.getUser(),UserDto.class));
//        postDto.setComments(modelMapper.map(socialPost.getComments(), CommentDto.class));

        Set<CommentDto> commentDtos = socialPost.getComments().stream()
                .map(comment -> modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toSet());
        postDto.setComments(commentDtos);

        System.out.println(postDto);
       return  postDto;

    }

    @Override
    public List<CategoryDto> getallCategories() {
        List<Categories>category=categoryRepo.findAll();
        List<CategoryDto>categoryDtos=category.stream().map((categorydata)->modelMapper
                .map(categorydata,CategoryDto.class)).collect(Collectors.toList());
        return categoryDtos;
    }

    @Override
    public List<PostDto> searchPost(String keyword) {
        List<SocialPost>socialPosts=postRepo.findByTitleContaining(keyword);
     List<PostDto> postDtos=   socialPosts.stream().map((socialPostData) -> {
            PostDto postDto = modelMapper.map(socialPostData, PostDto.class);

            postDto.setCategoryDto(modelMapper.map(socialPostData.getCategories(), CategoryDto.class));
            postDto.setUserDto(modelMapper.map(socialPostData.getUser(), UserDto.class));

            return postDto;
        }).collect(Collectors.toList());

        return postDtos;
    }

    @Override
    public List<PostDto> getAllPostByCategory(int categoryId) {
        Categories category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new UserNotFoundException("Category", "categoryId", categoryId));

        List<SocialPost> socialPosts= postRepo.findByCategories(category);

        List<PostDto>postDtos=socialPosts.stream().map((socialPostData) ->{
               PostDto postDto=modelMapper.map(socialPostData,PostDto.class);
               postDto.setCategoryDto(modelMapper.map(socialPostData.getCategories(),CategoryDto.class));
               postDto.setUserDto(modelMapper.map(socialPostData.getUser(),UserDto.class));
   return postDto;
                }).collect(Collectors.toList());
        System.out.println(postDtos);

        return postDtos;
    }

    @Override
    public List<PostDto> getAllPostByUser(int userId) {
       User user = userRepo.findById(userId).
                orElseThrow(() -> new CategoryNotFoundException("category", "category Id", userId));

         List<SocialPost>socialPosts=postRepo.findByUser( user);
         List<PostDto>postDtos=socialPosts.stream().map((socialPostData)->{
             PostDto postDto=modelMapper.map(socialPostData,PostDto.class);
             postDto.setUserDto(modelMapper.map(socialPostData.getUser(),UserDto.class));
             postDto.setCategoryDto(modelMapper.map(socialPostData.getCategories(),CategoryDto.class));
             return postDto;
         }).collect(Collectors.toList());
        return postDtos;
    }
}
