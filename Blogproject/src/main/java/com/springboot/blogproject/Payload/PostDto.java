package com.springboot.blogproject.Payload;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PostDto {
    private  int postId;
    private String title;

    private String postContent;
    private String imageName;
    private Date CurrrentDate;


    private CategoryDto categoryDto;
    private Set<CommentDto> comments =new HashSet<>();
    private UserDto userDto;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Set<CommentDto> getComments() {
        return comments;
    }

    public void setComments(Set<CommentDto> comments) {
        this.comments = comments;
    }

    public PostDto() {
    }

    public PostDto(String title, String postContent,
                   String imageName, Date currrentDate, CategoryDto categoryDto, UserDto userDto,int postId) {
        this.title = title;
        this.postContent = postContent;
        this.imageName = imageName;
        CurrrentDate = currrentDate;
        this.categoryDto = categoryDto;
        this.userDto = userDto;
        this.postId=postId;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Date getCurrrentDate() {
        return CurrrentDate;
    }

    public void setCurrrentDate(Date currrentDate) {
        CurrrentDate = currrentDate;
    }

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "id="+postId+'\''+
                "title='" + title + '\'' +
                ", postContent='" + postContent + '\'' +
                ", imageName='" + imageName + '\'' +
                ", CurrrentDate=" + CurrrentDate +
                ", categoryDto=" + categoryDto +
                ", userDto=" + userDto +
                '}';
    }
}
