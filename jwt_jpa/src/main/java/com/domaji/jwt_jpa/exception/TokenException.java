package com.domaji.jwt_jpa.exception;

public class TokenException extends RuntimeException{

    public TokenException(String message) {
        super(message);
    }
}
