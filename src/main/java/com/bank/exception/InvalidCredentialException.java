package com.bank.exception;

//This combines the previous IncorrectUsername and IncorrectPassword exceptions into one.
//With that, this will see when a username or password aren't in the database
public class InvalidCredentialException extends ValidationException{
    public InvalidCredentialException(String s){
        super(s);
    }
    
}
