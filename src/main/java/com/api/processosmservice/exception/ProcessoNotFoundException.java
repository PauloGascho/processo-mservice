package com.api.processosmservice.exception;

public class ProcessoNotFoundException extends RuntimeException {

    public ProcessoNotFoundException(String message) {
        super(message);
    }
    public ProcessoNotFoundException() {
        super("Processo não encontrado");
    }
}
