package com.kevinNguyen.GuessTheNumber.service;

public class DuplicateIDException extends Exception{
    public DuplicateIDException(String msg){
        super(msg);
    }

    public DuplicateIDException(String msg, Throwable cause){
        super(msg, cause);
    }
}
