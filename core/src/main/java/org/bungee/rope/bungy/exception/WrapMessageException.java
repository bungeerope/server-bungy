package org.bungee.rope.bungy.exception;

/**
 * @author ZhihaoQuinn
 * @since 2020/8/9
 */
public class WrapMessageException extends RuntimeException {

	public WrapMessageException(String message) {
		super(message);
	}

	public WrapMessageException(String message, Throwable cause) {
		super(message, cause);
	}

}