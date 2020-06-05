package com.td3a.ddd.core.exceptions;

public class ApplicationDomainException extends ApplicationException {
    public ApplicationDomainException(String message, Exception ex) {
        super(message, ex);
    }
}
