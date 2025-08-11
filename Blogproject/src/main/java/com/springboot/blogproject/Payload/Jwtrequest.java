package com.springboot.blogproject.Payload;

public class Jwtrequest {
    private  String username;
    private  String password;


    @Override
    public String toString() {
        return "Jwtrequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Jwtrequest() {
    }

    public Jwtrequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
