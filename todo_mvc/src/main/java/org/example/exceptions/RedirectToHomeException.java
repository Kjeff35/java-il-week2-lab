package org.example.exceptions;

public class RedirectToHomeException extends RuntimeException{
    public RedirectToHomeException(String message){
        super(message);
    }
}
