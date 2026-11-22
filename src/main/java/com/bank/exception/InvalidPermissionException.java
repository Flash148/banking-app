package com.bank.exception;

//This Exception is meant to catch if a customer is trying to perform
//an operation only an employee or admin can perform
public class InvalidPermissionException extends InvalidTransactionException{
    public InvalidPermissionException(String s){
        super(s);
    }
    
}
