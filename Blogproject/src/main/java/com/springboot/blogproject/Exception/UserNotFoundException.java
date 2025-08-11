package com.springboot.blogproject.Exception;

public class UserNotFoundException extends  RuntimeException{
    private  String userValue;
    private  String Message;
    private  int id;

    public UserNotFoundException(String userValue, String Message, int id){
        super(String.format("%s is not found. %s with id %d", userValue, Message, id));
        this.id=id;
        this.userValue=userValue;
        this.Message=Message;
    }

    public String getUserValue() {
        return userValue;
    }

    public void setUserValue(String userValue) {
        this.userValue = userValue;
    }

    @Override
    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserNotFoundException{" +
                "userValue='" + userValue + '\'' +
                ", Message='" + Message + '\'' +
                ", id=" + id +
                '}';
    }
}
