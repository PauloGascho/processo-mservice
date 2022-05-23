package com.api.processosmservice.exception;

public class ProcessoAlreadyExistsException extends RuntimeException{
    public ProcessoAlreadyExistsException(String message) {
        super(message);
    }
}
