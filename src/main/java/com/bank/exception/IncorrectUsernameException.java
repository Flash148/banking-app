package com.bank.exception;

//To be implemented when the database is fully implemented
//To be called when the username for either the customer or the employee
//doesn't match one in the database
public class IncorrectUsernameException extends ValidationException {
    public IncorrectUsernameException(String s){
        super(s);
    }
}
