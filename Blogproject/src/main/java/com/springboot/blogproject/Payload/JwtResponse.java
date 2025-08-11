package com.springboot.blogproject.Payload;



import org.modelmapper.spi.Tokens;


public class JwtResponse {
    private  String token;
    private  String  username;



    @Override
    public String toString() {
        return "JwtResponse{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public JwtResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public JwtResponse(String token, String username) {
        this.token = token;
        this.username = username;
    }


    public static class Builder {

        private String token;
        private String username;

        // Builder setter methods
        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        // Method to build JwtResponse
        public JwtResponse build() {
            return new JwtResponse(token, username);
        }
    }
}
