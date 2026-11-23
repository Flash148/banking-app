package com.bank.exception;

//This exception is meant to catch when either a customer or employee
//tries to do a withdrawl or a deposit on a closed/frozen account
public class TransactionOnClosedException extends InvalidTransactionException {
    public TransactionOnClosedException(String s){
        super(s);
    }
}
