package com.kevinNguyen.GuessTheNumber.service;

public class InvalidAnswerException extends Exception {
    public InvalidAnswerException (String msg){
        super(msg);
    }

    public InvalidAnswerException (String msg, Throwable cause){
        super(msg, cause);
    }
}
