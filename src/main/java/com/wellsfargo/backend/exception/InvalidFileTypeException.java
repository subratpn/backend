package com.wellsfargo.backend.exception;

public class InvalidFileTypeException extends RuntimeException {

    public InvalidFileTypeException(String msg) {
        super(msg);
    }

}
