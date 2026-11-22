package com.bank.exception;

//This high-level class is meant to encapsulate
//the different causes for the various exceptions made
public class Verification {
    //Uses ValidationException
    //IncorrectUsernameException
    //IncorrectPasswordException
    public void checkUserLogin(String username, String password) throws ValidationException{
        /*
            if(username is not in SQL_DATABASE){
                throw new IncorrectUsernameException("Username not Found.")
            }
            if(password is not in SQL_DATABASE){
                throw new IncorrectPasswordException("Password not Found.")
            }
         */
    }

    //This is exclusively for those that are on the Sign-Up screen
    public void checkUserSignUp(String username, String password) throws ValidationException{
        /*
            if(username is in SQL_DATABASE){
                throw new IsDuplicateException("Invalid Username. Please choose a different one.")
            }
            if(password is in SQL_DATABASE){
                throw new IsDuplicateException("Invalid Password. Please choose a different one.")
            }
        */
    }
}