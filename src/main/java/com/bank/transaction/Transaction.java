package com.bank.exception;

import java.util.Arrays;

//This high-level class is meant to encapsulate
//the different causes for the various exceptions made
public class Transaction {
    //Uses InvalidTransactionException
    //InvalidTransactionTypeException
    //TransitionOnClosedAccountException
    //InvalidPermissionException

    public void validTransaction(String transaction) throws InvalidTransactionException{
        //transaction.toUpperCase() will be done in the methods with the logic in place
        String[] transaction_type = new String[]{"DEPOSIT", "WITHDRAWAL", "TRANSFER_IN", "TRANSFER_OUT", "WIRE_IN", "WIRE_OUT"};
        if(!Arrays.asList(transaction_type).contains(transaction)){
            throw new InvalidTransactionTypeException("Invalid Transaction Type Detected.");
        }
    }

    public void closedAccountTransaction(String transaction, String status) throws InvalidTransactionException{
        if(!status.equals("ACTIVE")){
            throw new TransactionOnClosedException("Accessed Account is currently unavailable.");
        }
    }

    //transaction in this case are wire transfer assistance
    //as customers cannot help each other with wire transfers
    //Checks if the user is in the Employee table or the Customer table
    public void userPermissions(String transaction, String username, String password) throws InvalidTransactionException{
        /*
            data_obj = Object that references the database
            if(!data_obj.employees.contains(username, password)){
                throw new InvalidPermissionException("You are not authorized to access these settings.")
            }
        */
    }
}