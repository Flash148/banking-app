package com.bank.exception;

//To be fully implemented with database is set up
//Meant to be for when a customer tries to access other's information
//or when the customer tries to perform a command only an employee can do
public class InvalidUserException extends ValidationException{
    public InvalidUserException(String s){
        super(s);
    }
    
}
