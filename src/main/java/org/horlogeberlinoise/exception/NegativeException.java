package org.horlogeberlinoise.exception;

public class NegativeException extends IllegalArgumentException {
    public NegativeException(String message) {
        super(message);
    }
}
