package com.springbootbasiccrud.exception;

public class UserNotNullException extends RuntimeException{
    public UserNotNullException(String message){
        super(message);
    }
}
