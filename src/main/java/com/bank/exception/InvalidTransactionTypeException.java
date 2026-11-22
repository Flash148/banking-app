package com.bank.exception;

//Will be implemented with full use of database
//Meant to track if a user is performing another action besides
//The ones already available to them, and gives them an error
public class InvalidTransactionTypeException extends InvalidTransactionException{
    public InvalidTransactionTypeException(String s){
        super(s);
    }
    
}
