package com.springboot.blogproject.Payload;

import jakarta.validation.constraints.*;

public class UserDto {
    private int id;
    @NotEmpty(message = "size must be between of 3 to 20")
    @Size(min = 3, max = 20,message = "size must be between of 3 to 20")
    private String name;
    @NotEmpty
    @NotNull
    @Email (message = "plese enter correct email")



    private String email;
    @NotEmpty
    @NotNull
    @Size(min = 6, max = 14,message = "size must be between of 6 to 14")
    private String password;
    // @Digits()
    @NotNull (message = "age can't be null")
    private int age;
    @NotNull(message = "gender is mandatory")
    private String gender;


    public UserDto() {
    }

    public UserDto(int id, String name, String email, String password, int age, String gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
