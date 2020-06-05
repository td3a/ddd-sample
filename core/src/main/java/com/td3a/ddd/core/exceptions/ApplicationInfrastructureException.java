package com.td3a.ddd.core.exceptions;

public class ApplicationInfrastructureException extends ApplicationException {
    public ApplicationInfrastructureException(String message, Exception ex) {
        super(message, ex);
    }
}
