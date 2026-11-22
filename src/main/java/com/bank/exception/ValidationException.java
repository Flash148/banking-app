package com.bank.exception;

//To be set up once proper database is set up
//Meant to be the overarching class for the validation.
//Will include passord checks, invalid user checks
public class ValidationException extends Exception {
    public ValidationException(String s){
        super(s);
    }
    
}
