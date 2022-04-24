package org.example.user.exception;

public class NoSuchUserException extends RuntimeException {
	public NoSuchUserException(String login) {
		super("No user found for login: " + login);
	}
}
