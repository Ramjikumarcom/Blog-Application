package com.springboot.blogproject.Payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CategoryDto {

    private  int CId;
    @NotEmpty(message = "title should not be empty")
    @Size(min = 4,max = 20 ,message = "please enter minumn 4 character and maximum 20 character")
    private String CTitle;
    @NotEmpty(message = "Description should not be Empty ")
    @Size(min = 10,max = 30,message = "minumum size is 10 and maximu size is 30")
    private  String CDescription;

    public CategoryDto() {
    }

    public CategoryDto(int CId, String CTitle, String CDescription) {
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
        return "CategoryDto{" +
                "CId=" + CId +
                ", CTitle='" + CTitle + '\'' +
                ", CDescription='" + CDescription + '\'' +
                '}';
    }
}
