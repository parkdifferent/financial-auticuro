package com.auticuro.core.exception;

public class BalanceLimitException extends RuntimeException {
    public BalanceLimitException(String message) {
        super(message);
    }
}
