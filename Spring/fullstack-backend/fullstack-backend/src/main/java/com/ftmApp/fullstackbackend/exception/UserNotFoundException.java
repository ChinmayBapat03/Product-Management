package com.ftmApp.fullstackbackend.exception;

public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(Long id) {
		super("Could not find product with ID: "+id);
	}
}
