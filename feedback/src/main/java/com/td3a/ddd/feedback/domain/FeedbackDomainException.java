package com.td3a.ddd.feedback.domain;

import com.td3a.ddd.core.domain.DomainException;

public class FeedbackDomainException extends DomainException {
	public FeedbackDomainException(String message) {
		super(message);
	}
}
