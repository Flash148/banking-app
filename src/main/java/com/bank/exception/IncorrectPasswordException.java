package com.bank.exception;

//This will be fully implemented when the database is set up
//Meant to check both customer and employee passwords to see if they are
//correct
public class IncorrectPasswordException extends ValidationException{
    public IncorrectPasswordException(String s){
        super(s);
    }
    
}
