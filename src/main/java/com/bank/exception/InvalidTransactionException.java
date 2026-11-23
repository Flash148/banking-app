package com.bank.exception;

//This is to be fully implemented when the transactions are
//available to perform
//Is the higher class that houses invalid transactions, illegal operations on
//frozen and closed accounts
public class InvalidTransactionException extends Exception{
    public InvalidTransactionException(String s){
        super(s);
    }
}
