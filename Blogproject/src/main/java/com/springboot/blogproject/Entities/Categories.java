package com.springboot.blogproject.Entities;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CId;
    private String CTitle;
    private String CDescription;


    @OneToMany (mappedBy = "categories",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<SocialPost> socialPosts = new ArrayList<>();


    public Categories() {
    }

    public Categories(int CId, String CTitle, String CDescription) {
        this.CId = CId;
        this.CTitle = CTitle;
        this.CDescription = CDescription;
    }

    public int getCId() {
        return CId;
    }

    public void setCId(int CId) {
        this.CId = CId;
    }

    public String getCTitle() {
        return CTitle;
    }

    public void setCTitle(String CTitle) {
        this.CTitle = CTitle;
    }

    public String getCDescription() {
        return CDescription;
    }

    public void setCDescription(String CDescription) {
        this.CDescription = CDescription;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "CId=" + CId +
                ", CTitle='" + CTitle + '\'' +
                ", CDescription='" + CDescription + '\'' +
                '}';
    }
}
