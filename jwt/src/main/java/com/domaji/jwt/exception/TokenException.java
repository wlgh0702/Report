package com.domaji.jwt.exception;

public class TokenException extends RuntimeException{
    public TokenException(String message) {
        super(message);
    }
}
