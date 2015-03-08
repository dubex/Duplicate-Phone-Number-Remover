package com.netcracker.assignment;

/**
 * @author Prakash KumarDubey
 * This Exception occur when Inappropriate number is provided.
 *
 */
public class InAppropriateNumberException extends Exception {
	private String message;

	public InAppropriateNumberException() {
	}

	public InAppropriateNumberException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String toString() {
		return message;
	}
}
