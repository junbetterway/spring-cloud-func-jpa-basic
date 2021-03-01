package com.junbetterway.serverless.springcloudfunc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccountNotFoundException extends RuntimeException {
	
	public AccountNotFoundException(final Long id) {
		super("Account with ID '" + id + "' does not exist!");
	}
	
}
