package com.domaji.jwt.exception;

public class DuplicatedMemberIdException extends RuntimeException{

    public DuplicatedMemberIdException(String message) {
        super(message);
    }
}
