package com.bank.exception;

//When a user signs up, this is meant to check if the username
//and password are already in the database, and will thus tell the user
public class IsDuplicateException extends ValidationException{
    public IsDuplicateException(String s){
        super(s);
    }
}