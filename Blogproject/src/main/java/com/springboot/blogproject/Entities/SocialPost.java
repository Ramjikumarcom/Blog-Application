package com.springboot.blogproject.Entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SocialPost")
public class SocialPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Postid")
    private  int postId;
    @Column(name = "Post_title",nullable = false,length = 100)
    private String title;
    @Column(name = "PostContent",length = 3000,nullable = false)
    private String postContent;
    private String imageName;
    private Date CurrrentDate;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Categories categories;

    @ManyToOne
    @JoinColumn
    private  User user;

  @OneToMany(mappedBy = "socialPost",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
  private Set<CommentEntity> comments =new HashSet<>();

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }

    public SocialPost() {
    }

    public SocialPost(int postId, String title, String postContent,
                      String imageName, Date currrentDate, Categories categories, User user) {
        this.postId = postId;
        this.title = title;
        this.postContent = postContent;
        this.imageName = imageName;
        CurrrentDate = currrentDate;
        this.categories = categories;
        this.user = user;
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

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SocialPost{" +
                "id=" + postId +
                ", title='" + title + '\'' +
                ", postContent='" + postContent + '\'' +
                ", imageName='" + imageName + '\'' +
                ", CurrrentDate=" + CurrrentDate +
                ", categories=" + categories +
                ", user=" + user +
                '}';
    }
}
