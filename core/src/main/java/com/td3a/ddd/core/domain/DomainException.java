package com.td3a.ddd.core.domain;

public class DomainException extends RuntimeException {
	public DomainException(String message) {
		super(message);
	}

	public DomainException(String message, Throwable cause) {
		super(message, cause);
	}
}
